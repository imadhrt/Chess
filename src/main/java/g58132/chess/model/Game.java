package g58132.chess.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author elhar
 */
public class Game implements Model {

    private Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;

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
            Position positionBlanc = new Position(1, colonne);
            Piece pieceBlanc = new Piece(Color.WHITE);
            board.setPiece(pieceBlanc, positionBlanc);

            Position positionNoir = new Position(6, colonne);
            Piece pieceNoir = new Piece(Color.BLACK);
            board.setPiece(pieceNoir, positionNoir);

        }
        this.currentPlayer = white;

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
                    + "plateau ");
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
                    + "plateau ");
        }
        return this.board.containsOppositeColor(pos, this.currentPlayer.getColor());
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
        if (getPiece(oldPos) == null
                || getPiece(oldPos).getColor() != currentPlayer.getColor()
                || board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
            throw new IllegalArgumentException("La nouvelle position du plateau "
                    + "n'est pas valide ");
        }
        this.board.setPiece(getPiece(oldPos), newPos);
        while (!isGameOver()) {
            this.currentPlayer = getOppositePlayer();
        }

    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        return board.getPositionOccupiedBy(black).size() != 0 //si liste pas vide
                || board.getPositionOccupiedBy(white).size() != 0;

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
