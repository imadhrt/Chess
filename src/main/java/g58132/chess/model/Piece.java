package g58132.chess.model;

import java.util.ArrayList;
import java.util.List;

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
     *  movement of piece on the board
     * 
     * Allows to add all the possible position on the board.
     * 
     * @param position is a position of a piece on the board
     * @param board is a game board 
     * @return a list of all possible positions of a move for a pawn
     * in a given position
     */

    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> positionPossible = new ArrayList();
        positionPossible.addAll(movesNorthOrSouth(position, board));
        positionPossible.addAll(moveTwoCaseSouthOrNorth(position, board));
        positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board));

        return positionPossible;
    }

    private List<Position> movesNorthOrSouth(Position position, Board board) {
        List<Position> listePosition = new ArrayList();
        if (board.containsOppositeColor(position, color.BLACK)) {
            /**
             * verifie si à la position du plateau la case est blanc cela
             * signifie que le pion est noir et si c'est noir cela signifie que
             * s'est un pion blanc*
             */
            if (board.isFree(position.next(Direction.N))) {
                listePosition.add(position.next(Direction.N));

            }
        } else {
            if (board.isFree(position.next(Direction.S))) {
                listePosition.add(position.next(Direction.S));
            }
        }
        return listePosition;
    }

    private List<Position> moveTwoCaseSouthOrNorth(Position position, Board board) {
        List<Position> listePosition = new ArrayList();

        if (board.containsOppositeColor(position, color.BLACK)) {
            if (board.isFree(position.next(Direction.N))
                    && //premiere case libre
                    board.isFree(position.next(Direction.N).next(Direction.N))
                    &&// deuxième case libre
                    board.getInitialPawnRow(color) == 1) { //position initiale
                listePosition.add(position.next(Direction.N).next(Direction.N));

            }
        } else {
            if (board.isFree(position.next(Direction.S))
                    && board.isFree(position.next(Direction.S))
                    && board.getInitialPawnRow(color) == 6) {
                listePosition.add(position.next(Direction.S).next(Direction.S));

            }

        }
        return listePosition;
    }

    private List<Position> moveDiagonalSouthEastOrSouthWhest(Position position,
            Board board) {
        List<Position> listePosition = new ArrayList();
        if (board.containsOppositeColor(position, color.BLACK)) {
            if ((!board.isFree(position.next(Direction.NW))
                    && board.containsOppositeColor(position.next(Direction.NW), color.WHITE))) {
                listePosition.add(position.next(Direction.NW));
            }
            if ((!board.isFree(position.next(Direction.NE))
                    && board.containsOppositeColor(position.next(Direction.NE), color.WHITE))) {
                listePosition.add(position.next(Direction.NE));

            }

        } else {
            if ((!board.isFree(position.next(Direction.SW)))
                    && board.containsOppositeColor(position.next(Direction.SW), color.BLACK)) {
                listePosition.add(position.next(Direction.SW));

            }
            if ((!board.isFree(position.next(Direction.SE)))
                    && board.containsOppositeColor(position.next(Direction.SE), color.BLACK)) {
                listePosition.add(position.next(Direction.SE));

            }

        }
        return listePosition;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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
    

}
