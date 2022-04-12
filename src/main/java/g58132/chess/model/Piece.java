package g58132.chess.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the piece on the game.
 *
 * @author elhar
 */
public class Piece {

    private Color color;

    /**
     * Constructor of piece
     *
     * Allows to initialise the color attribute to value.
     *
     * @param color is color of the piece
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Accessory of the color
     *
     * Allows access to the value of the color attribute.
     *
     * @return the color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     *
     * movement of piece on the board
     *
     * Allows to add all the possible position on the board.
     *
     * @param position is a position of a piece on the board
     * @param board is a game board
     * @return a list of all possible positions of a move for a pawn in a given
     * position
     */
    public List<Position> getPossibleMoves(Position position, Board board) {

        List<Position> positionPossible = new ArrayList();

        if (color.equals(Color.WHITE)) {
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
        if ((board.getInitialPawnRow(color) != position.getRow())) {//verifie 
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
                && board.containsOppositeColor(position.next(dir), color))) {
            listePosition.add(position.next(dir));
        }

        return listePosition;

    }

    /**
     * Equals
     *
     * Allows to compare if the two objects are equal.
     *
     * @param obj is an object
     * @return true if theys are equal and false if they are not equals
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
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.color);
        return hash;
    }

}
