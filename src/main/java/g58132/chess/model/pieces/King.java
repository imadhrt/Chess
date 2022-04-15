package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the King on the game.
 *
 * @author elhar
 */
public class King extends Piece {

    /**
     * Constructor of king
     *
     * use the parent constructor
     *
     * @param color is color of the king
     */
    public King(Color color) {
        super(color);
    }

    /**
     *
     * Movement of king on the board
     *
     * Allows to add all the possible position on the board.
     *
     * @param position is a position of a king on the board
     * @param board is a game board
     * @return a list of all possible positions of a move for a king in a given
     * position
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> listePosition = new ArrayList();
        listePosition.addAll(displacementKing(position, board, Direction.N));
        listePosition.addAll(displacementKing(position, board, Direction.S));
        listePosition.addAll(displacementKing(position, board, Direction.W));
        listePosition.addAll(displacementKing(position, board, Direction.E));
        listePosition.addAll(displacementKing(position, board, Direction.NE));
        listePosition.addAll(displacementKing(position, board, Direction.NW));
        listePosition.addAll(displacementKing(position, board, Direction.SE));
        listePosition.addAll(displacementKing(position, board, Direction.SW));

        return listePosition;

    }

    /**
     * displacement of king( north, south, west, east, northEast, northWest,
     * southWest, southEast)
     *
     * Allows to check if a king in a given position can move in all direction
     * but one square and add it to the list.
     *
     * @param position is a position of a king on the board
     * @param board is a game board
     * @param dir is a direction king
     * @return the list of positions that a king in a given position can make
     */
    private List<Position> displacementKing(Position position, Board board, Direction dir) {
        List<Position> listePosition = new ArrayList();

        if (board.contains(position.next(dir)) && (board.containsOppositeColor(position.next(dir), super.getColor()) || board.isFree(position.next(dir)))) {
            listePosition.add(position.next(dir));
        }
        return listePosition;

    }

}
