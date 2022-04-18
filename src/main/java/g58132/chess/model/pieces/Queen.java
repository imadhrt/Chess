package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the queen on the game.
 *
 * @author elhar
 */
public class Queen extends Piece {

    /**
     * Constructor of king
     *
     * use the parent constructor
     *
     * @param color is color of the king
     */

    public Queen(Color color) {
        super(color);
    }

    /**
     *
     * Movement of queen on the board
     *
     * Allows to add all the possible position the queen can make on the board.
     *
     * @param position is a position of a queen on the board
     * @param board is a game board
     * @return a list of all possible positions of a move for a queen in a given
     * position
     */

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> listePos = new ArrayList();
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.N));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.S));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.E));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.W));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.NE));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.NW));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.SE));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.SW));

        return listePos;

    }

}
