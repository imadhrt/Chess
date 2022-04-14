package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the knight on the game.
 *
 * @author elhar
 */
public class Knight extends Piece {

    /**
     * Constructor of knight
     *
     * use the parent constructor
     *
     * @param color is color of the knight
     */
    public Knight(Color color) {
        super(color);
    }

    /**
     *
     * @param position
     * @param board
     * @return
     */

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> listePosition = new ArrayList();
        listePosition.addAll(displacementL(position, board, Direction.E, Direction.N));
        listePosition.addAll(displacementL(position, board, Direction.E, Direction.S));
        listePosition.addAll(displacementL(position, board, Direction.W, Direction.N));
        listePosition.addAll(displacementL(position, board, Direction.W, Direction.S));
        listePosition.addAll(displacementL(position, board, Direction.N, Direction.E));
        listePosition.addAll(displacementL(position, board, Direction.S, Direction.E));
        listePosition.addAll(displacementL(position, board, Direction.N, Direction.W));
        listePosition.addAll(displacementL(position, board, Direction.S, Direction.W));
        return listePosition;

    }

    /**
     *
     * @param position
     * @param board
     * @param dir1
     * @param dir2
     * @return
     */

    private List<Position> displacementL(Position position, Board board, Direction dir1, Direction dir2) {
        List<Position> listePosition = new ArrayList();

        if (board.contains(position.next(dir1).next(dir1).next(dir2))
                && ((board.containsOppositeColor(position.next(dir1).next(dir1).next(dir2), super.getColor())) || board.isFree(position.next(dir1).next(dir1).next(dir2)))) {
            listePosition.add(position.next(dir1).next(dir1).next(dir2));

        }
        return listePosition;

    }

}
