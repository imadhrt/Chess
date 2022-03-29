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
     * Accessor of the color
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

        positionPossible.addAll(movesNorthOrSouth(position, board));
        positionPossible.addAll(moveTwoCaseSouthOrNorth(position, board));
        positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board));

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
     * @return the list of positions that a pawn in a given position can make
     */
    private List<Position> movesNorthOrSouth(Position position, Board board) {
        List<Position> listePosition = new ArrayList();

        if (color.equals(Color.WHITE)) {
            /**
             * verifie si à la position du plateau la case est blanc cela
             * signifie que le pion est noir et si c'est noir cela signifie que
             * s'est un pion blanc*
             */
            if (board.contains(position.next(Direction.N)) && board.isFree(position.next(Direction.N))) {
                listePosition.add(position.next(Direction.N));

            }
        }
        if (color.equals(Color.BLACK)) {
            if (board.contains(position.next(Direction.S)) && board.isFree(position.next(Direction.S))) {
                listePosition.add(position.next(Direction.S));
            }
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
     * @return the list of positions that a pawn in a given position can make
     */
    private List<Position> moveTwoCaseSouthOrNorth(Position position, Board board) {
        List<Position> listePosition = new ArrayList();
        if ((board.getInitialPawnRow(color) != position.getRow())) {//verifie 
            //si position initial
            return listePosition;
        }

        if (color.equals(Color.WHITE)) {
            if (board.isFree(position.next(Direction.N))
                    && //premiere case libre
                    board.isFree(position.next(Direction.N).next(Direction.N)) // deuxième case libre
                    ) {

                listePosition.add(position.next(Direction.N).next(Direction.N));

            }else{
                return listePosition;
            }
            
        }
        if (color.equals(Color.BLACK)) {
            if (board.isFree(position.next(Direction.S))
                    && board.isFree(position.next(Direction.S).next(Direction.S))) {

                listePosition.add(position.next(Direction.S).next(Direction.S));

            }

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
     * @return the list of positions that a pawn in a given position can make
     */
    private List<Position> moveDiagonalSouthEastOrSouthWhest(Position position,
            Board board) {
        List<Position> listePosition = new ArrayList();

        if (color.equals(Color.WHITE)) {
            if ((board.contains(position.next(Direction.NW)) && !board.isFree(position.next(Direction.NW))
                    && board.containsOppositeColor(position.next(Direction.NW), color))) {
                listePosition.add(position.next(Direction.NW));
            }
            if ((board.contains(position.next(Direction.NE)) && !board.isFree(position.next(Direction.NE))
                    && board.containsOppositeColor(position.next(Direction.NE), color))) {
                listePosition.add(position.next(Direction.NE));

            }

        }
        if (color.equals(Color.BLACK)) {
            if ((board.contains(position.next(Direction.SW)) && !board.isFree(position.next(Direction.SW)))
                    && board.containsOppositeColor(position.next(Direction.SW), color)) {
                listePosition.add(position.next(Direction.SW));

            }
            if ((board.contains(position.next(Direction.SE)) && !board.isFree(position.next(Direction.SE)))
                    && board.containsOppositeColor(position.next(Direction.SE), color)) {
                listePosition.add(position.next(Direction.SE));

            }

        }
        return listePosition;
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

