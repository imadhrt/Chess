package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;

import g58132.chess.model.Position;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

/**
 * Represents the piece on the game.
 *
 * @author elhar
 */
public abstract class Piece {

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
    public abstract List<Position> getPossibleMoves(Position position, Board board);

//        List<Position> positionPossible = new ArrayList();
//
//        if (color.equals(Color.WHITE)) {
//            positionPossible.addAll(movesNorthOrSouth(position, board, Direction.N));
//            positionPossible.addAll(moveTwoCaseSouthOrNorth(position, board, Direction.N));
//            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.NW));
//            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.NE));
//
//        } else {
//            positionPossible.addAll(movesNorthOrSouth(position, board, Direction.S));
//            positionPossible.addAll(moveTwoCaseSouthOrNorth(position, board, Direction.S));
//            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.SW));
//            positionPossible.addAll(moveDiagonalSouthEastOrSouthWhest(position, board, Direction.SE));
//
//        }
//
//        return positionPossible;
//    }
    /**
     *
     * Pieces capture
     *
     * Allows to provide the positions in which the can capture another piece
     *
     * @param position is a position of a piece on the board
     * @param board is a game board
     * @return a list of all piece that can be captured
     */
    public List<Position> getCapturePositions(Position position, Board board) {
        return getPossibleMoves(position, board);

    }

    /**
     * Moving the bishop, the queen and the rook
     *
     * Allows to check if the piece in a given position can move and add it to
     * the list.
     *
     * @param position is a position of a piece on the board
     * @param board is a game board
     * @param dir is a direction a piece
     * @return the list of positions that a piece in a given position can make
     */
    protected List<Position> MoveQueenAndBishopAndRook(Position position, Board board, Direction dir) {
        List<Position> positionPossible = new ArrayList();
        Position pos = position;

        while (board.contains(pos.next(dir)) && ((board.isFree(pos.next(dir))) || board.containsOppositeColor(pos.next(dir), this.color))) {
            //vérifie s'il est dans le plateau et case vide ou contient un pion opposé
            if (board.containsOppositeColor(pos.next(dir), this.color)) { // si le pion est de couleur opposé il ajoute dans la liste et retourne la liste pour ne pas continuer à ajouter des positions
                positionPossible.add(pos.next(dir));
                return positionPossible;
            }

            positionPossible.add(pos.next(dir));
            pos = pos.next(dir);

        }
        return positionPossible;

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
