package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the bishop on the game.
 *
 * @author elhar
 */
public class Bishop extends Piece {

    /**
     * Constructor of king
     *
     * use the parent constructor
     *
     * @param color is color of the king
     */
    public Bishop(Color color) {
        super(color);
    }

    /**
     *
     * Movement of bishop on the board
     *
     * Allows to add all the possible position the bishop can make on the board.
     *
     * @param position is a position of a bishop on the board
     * @param board is a game board
     * @return a list of all possible positions of a move for a bishop in a
     * given position
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> listePos = new ArrayList();
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.NE));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.NW));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.SE));
        listePos.addAll(MoveQueenAndBishopAndRook(position, board, Direction.SW));

        return listePos;

    }

}
