package g58132.chess.model;

import g58132.chess.model.pieces.Bishop;
import g58132.chess.model.pieces.King;
import g58132.chess.model.pieces.Knight;
import g58132.chess.model.pieces.Pawn;
import g58132.chess.model.pieces.Piece;
import g58132.chess.model.pieces.Queen;
import g58132.chess.model.pieces.Rook;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * represents an action on the game and shows the state of the game
 *
 * @author elhar
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;
    private King whiteKing;
    private King blackKing;
    private final GameState state;

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
        this.state = GameState.PLAY;
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        this.currentPlayer = this.white;

        // initialiser roi blan et noir
        this.whiteKing = new King(Color.WHITE);
        this.blackKing = new King(Color.BLACK);

        for (int colonne = 0; colonne < 8; colonne++) {

            optimizedStart(1, Color.WHITE);
            optimizedStart(6, Color.BLACK);

        }
        //Tour Blanc
        board.setPiece(new Rook(Color.WHITE), new Position(0, 0));
        board.setPiece(new Rook(Color.WHITE), new Position(0, 7));
        //Tour noir
        board.setPiece(new Rook(Color.BLACK), new Position(7, 0));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 7));

        //Cavalier Blanc
        board.setPiece(new Knight(Color.WHITE), new Position(0, 1));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 6));

        //Cavalier Blanc
        board.setPiece(new Knight(Color.BLACK), new Position(7, 1));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 6));

        //Fou blanc
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 2));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 5));
        //Fou noir
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 2));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 5));
        // Reine Blanc
        board.setPiece(new Queen(Color.WHITE), new Position(0, 3));
        //Reine Noir
        board.setPiece(new Queen(Color.BLACK), new Position(7, 3));

        //Roi Blanc
        board.setPiece(new King(Color.WHITE), new Position(0, 4));
        //Roi Noir
        board.setPiece(new King(Color.BLACK), new Position(7, 4));

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
                    + " la pièce située à la position actuelle  ");

        }
        if (IsValidMove(oldPos, newPos)) {

            this.board.setPiece(getPiece(oldPos), newPos);
            this.board.dropPiece(oldPos);
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

    /**
     * Accessory of state
     *
     * Allows access to the value of the state attribute.
     *
     * @return the value of the state attribute
     */
    @Override
    public GameState getState() {
        return this.state;
    }

    /**
     * Is valide move
     *
     * allows to check that the movement of a piece from the oldPos position to
     * the newPos position is valid.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @return true if the move is possible or false it is not.
     * @throws IllegalArgumentException the starting position oldPos does not
     * contain piece.
     * @throws IllegalArgumentException moving the piece from oldPos to newPos
     * is not a possible move for the piece in question.
     */
    @Override
    public boolean IsValidMove(Position oldPos, Position newPos) {
        boolean isNotContainsKing = true;
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("La position départ ne contient aucune pièce");
        }
        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("Le coup n'est pas valable pour "
                    + " la pièce située à la position actuelle  ");
        }

        this.board.setPiece(getPiece(oldPos), newPos);
        this.board.dropPiece(oldPos);
        this.currentPlayer = getOppositePlayer();

        if (getCapturePositions(this.currentPlayer).contains(board.getPiecePosition(oppositeKingColor()))) {
            isNotContainsKing = false;

        }
        this.board.setPiece(getPiece(newPos), oldPos);
        this.board.dropPiece(newPos);
        this.currentPlayer = getOppositePlayer();

        return isNotContainsKing;

    }

    /**
     * Current King
     *
     * allows to check the current king
     *
     * @return the black king if the current player is white and white king if
     * it is black
     */
    private King oppositeKingColor() {
        return this.currentPlayer == white ? blackKing : whiteKing;
    }

    /**
     * Capture position
     *
     * Allows to determine all the positions in which a player can capture
     * another piece.
     *
     * @param player is a color player
     * @return all positions at which the player can capture another piece
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> listePos = new ArrayList();
        List<Position> pos = board.getPositionOccupiedBy(player);
        for (Position position : pos) {
            listePos.addAll(getPossibleMoves(position));

        }

        return listePos;
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
