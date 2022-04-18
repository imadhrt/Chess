package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the rook on the game.
 *
 * @author elhar
 */
public class Rook extends Piece {

    /**
     * Constructor of king
     *
     * use the parent constructor
     *
     * @param color is color of the king
     */

    public Rook(Color color) {
        super(color);
    }

    /**
     *
     * Movement of rook on the board
     *
     * Allows to add all the possible position the rook can make on the board.
     *
     * @param position is a position of a rook on the board
     * @param board is a game board
     * @return a list of all possible positions of a move for a rook in a given
     * position
     */

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> listePosition = new ArrayList();
        listePosition.addAll(MoveQueenAndBishopAndRook(position, board, Direction.N));
        listePosition.addAll(MoveQueenAndBishopAndRook(position, board, Direction.S));
        listePosition.addAll(MoveQueenAndBishopAndRook(position, board, Direction.E));
        listePosition.addAll(MoveQueenAndBishopAndRook(position, board, Direction.W));
        return listePosition;

    }

}
