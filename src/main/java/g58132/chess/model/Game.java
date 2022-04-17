package g58132.chess.model;

import g58132.chess.model.pieces.Pawn;
import g58132.chess.model.pieces.Piece;
import java.util.List;
import java.util.Objects;

/**
 * represents an action on the game and shows the state of the game
 *
 * @author elhar
 */
public class Game implements Model {

    private Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;

    /**
     * Constructor of game
     *
     * Allows to initialise attribute to instance (value)
     *
     */
    public Game() {
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
        this.board = new Board();
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        for (int colonne = 0; colonne < 8; colonne++) {

            optimizedStart(1, Color.WHITE);
            optimizedStart(6, Color.BLACK);

        }
        this.currentPlayer = this.white;

    }

    private void optimizedStart(int initialPos, Color col) {
        for (int colonne = 0; colonne < 8; colonne++) {
            board.setPiece(new Pawn(col), new Position(initialPos, colonne));

        }

    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le"
                    + " plateau ");
        }
        return this.board.getPiece(pos);

    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        return this.currentPlayer == white ? black : white;

    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le"
                    + " plateau ");
        }
        return this.board.getPiece(pos).getColor() == currentPlayer.getColor();
    }

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * game is not over, change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board, or 2) oldPos does not contain a piece, or 3) the piece does
     * not belong to the current player, or 4) the move is not valid for the
     * piece located at position oldPos
     *
     *
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if ((!board.contains(newPos)) || (!board.contains(oldPos))) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau.");
        }
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("la position  ne "
                    + " contient pas de pièce");
        }
        if (getPiece(oldPos).getColor() != currentPlayer.getColor()) {
            throw new IllegalArgumentException("La piece n'appartient pas au "
                    + " joueur actuel");
        }
        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("Le coup n'est pas valable pour "
                    + " la pièce située à la position actuel  ");

        }

        this.board.setPiece(getPiece(oldPos), newPos);
        this.board.dropPiece(oldPos);
        this.currentPlayer = getOppositePlayer();

    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        List<Position> listePos = this.board.getPositionOccupiedBy(this.currentPlayer);
        boolean gameOver = true;
        for (int i = 0; i < listePos.size() && gameOver; i++) {
            Position pos = listePos.get(i);
            if (!this.getPossibleMoves(pos).isEmpty()) {
                gameOver = false;

            }

        }
        return gameOver;

    }

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return this.board.getPiece(position).getPossibleMoves(position, board);

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.board);
        hash = 97 * hash + Objects.hashCode(this.white);
        hash = 97 * hash + Objects.hashCode(this.black);
        hash = 97 * hash + Objects.hashCode(this.currentPlayer);
        return hash;
    }

    /**
     * Equals
     *
     * Allows to compare if the two object are equals.
     *
     * @param obj is an object
     * @return true if theys are equals and false if they are not equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (!Objects.equals(this.white, other.white)) {
            return false;
        }
        if (!Objects.equals(this.black, other.black)) {
            return false;
        }
        if (!Objects.equals(this.currentPlayer, other.currentPlayer)) {
            return false;
        }
        return true;
    }

}
