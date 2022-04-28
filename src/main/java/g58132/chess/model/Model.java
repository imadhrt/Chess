package g58132.chess.model;

import g58132.chess.model.pieces.Piece;
import java.util.List;

/**
 *
 * @author elhar
 */
public interface Model {

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    public void start();

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    public Piece getPiece(Position pos);

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    public Player getCurrentPlayer();

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    public Player getOppositePlayer();

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
    public boolean isCurrentPlayerPosition(Position pos);

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * game is not over, change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if
     *
     */
    public void movePiecePosition(Position oldPos, Position newPos);

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver();

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    public List<Position> getPossibleMoves(Position position);

    /**
     * Accessory of state
     *
     * Allows access to the value of the state attribute.
     *
     * @return the value of the state attribute
     */
    public GameState getState();

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
    public boolean isValidMove(Position oldPos, Position newPos);

}
