package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the pawn on the game.
 *
 * @author elhar
 */
public class Pawn extends Piece {

    /**
     * Constructor of pawn
     *
     * use the parent constructor
     *
     * @param color is color of the pawn
     */
    public Pawn(Color color) {
        super(color);
    }

    /**
     *
     * movement of pawn on the board
     *
     * Allows to add all the possible position the pawn can make on the board.
     *
     * @param position is a position of a pawn on the board
     * @param board is a game board
     * @return a list of all possible positions of a move for a pawn in a given
     * position
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {

        List<Position> positionPossible = new ArrayList();

        if (super.getColor().equals(Color.WHITE)) {
            positionPossible.addAll(movesNorthOrSouth(position, board, Direction.N));
            positionPossible.addAll(moveTwoCaseSouthOrNorth(position, board, Direction.N));
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.NW));
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.NE));

        } else {
            positionPossible.addAll(movesNorthOrSouth(position, board, Direction.S));
            positionPossible.addAll(moveTwoCaseSouthOrNorth(position, board, Direction.S));
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.SW));
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.SE));

        }

        return positionPossible;
    }

    /**
     * Capture of an adverse piece in diagonal
     *
     * Allows to check if a pawn in a given position can move diagonaly
     * northEast or nortWhest (white pawn) or southWhest or southEast(black
     * pawn) and add it to the list.
     *
     * @param position is a position of a pawn on the board
     * @param board is a game board
     * @return the list of positions that a pawn in a given position can make
     */
    @Override
    public List<Position> getCapturePositions(Position position, Board board) {
        List<Position> positionPossible = new ArrayList();

        if (super.getColor().equals(Color.WHITE)) {
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.NW));
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.NE));

        } else {
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.SW));
            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.SE));

        }

        return positionPossible;

    }

    /**
     * Moving a piece north or south
     *
     * Allows to check if a pawn in a given position can move north or south and
     * add it to the list.
     *
     * @param position is a position of a pawn on the board
     * @param board is a game board
     * @param dir is a direction pawn
     * @return the list of positions that a pawn in a given position can make
     */
    private List<Position> movesNorthOrSouth(Position position, Board board, Direction dir) {
        List<Position> listePosition = new ArrayList();

        if (board.contains(position.next(dir)) && board.isFree(position.next(dir))) {
            listePosition.add(position.next(dir));

        }
        return listePosition;
    }

    /**
     * moving a piece two squares(getInitialPawnRow) north or south
     *
     * Allows to check if a pawn in a given position can move two squares north
     * or south and add it to the list.
     *
     * @param position is a position of a pawn on the board
     * @param board is a game board
     * @param dir is a direction pawn
     * @return the list of positions that a pawn in a given position can make
     */
    private List<Position> moveTwoCaseSouthOrNorth(Position position, Board board, Direction dir) {
        List<Position> listePosition = new ArrayList();
        if ((board.getInitialPawnRow(super.getColor()) != position.getRow())) {//verifie 
            //si position initial
            return listePosition;
        }

        if (board.isFree(position.next(dir))
                && //premiere case libre
                board.isFree(position.next(dir).next(dir)) // deuxième case libre
                ) {

            listePosition.add(position.next(dir).next(dir));

        }
        return listePosition;
    }

    /**
     * moving a piece diagonally
     *
     * Allows to check if a pawn in a given position can move diagonaly
     * northEast or nortWhest (white pawn) or southWhest or southEast(black
     * pawn) and add it to the list.
     *
     * @param position is a position of a pawn on the board
     * @param board is a game board
     * @param dir is a direction pawn
     * @return the list of positions that a pawn in a given position can make
     */
    private List<Position> moveDiagonalSouthEastOrSouthWhest(Position position, Board board, Direction dir) {
        List<Position> listePosition = new ArrayList();

        if ((board.contains(position.next(dir)) && !board.isFree(position.next(dir))
                && board.containsOppositeColor(position.next(dir), super.getColor()))) {
            listePosition.add(position.next(dir));
        }

        return listePosition;

    }

}
