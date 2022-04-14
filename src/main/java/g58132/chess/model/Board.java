package g58132.chess.model;

import g58132.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Represents the game board.
 *
 * @author elhar
 */
public class Board {

    private Square[][] squares;

    /**
     * Constructor whitout parameter
     *
     * Initialize the game board
     */
    public Board() {
        this.squares = new Square[8][8];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = new Square();

            }

        }

    }

    /**
     * Checks position
     *
     * @param pos is an position
     * @return true if the position is on the board and false if the position is
     * not on the board
     */
    public boolean contains(Position pos) {
        return ((pos.getRow() >= 0 && pos.getRow() <= 7) && (pos.getColumn() >= 0
                && pos.getColumn() <= 7));

    }

    /**
     * Initial Pawn Row
     *
     * allows to assign a value to the color.
     *
     * @param color is a the color
     * @return 6 if the color is black and 1 if the color is white
     */
    public int getInitialPawnRow(Color color) {

        return color == Color.BLACK ? 6 : 1;
    }

    /**
     * Mutator piece
     *
     * Allows to place the piece on the corresponding square.
     *
     * @param piece is an piece
     * @param position is an position on the play
     * @throw pos if the position is not on the board
     */
    public void setPiece(Piece piece, Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau!!!  ");
        }
        Square pawnPiece = new Square(piece);

        this.squares[position.getRow()][position.getColumn()] = pawnPiece;
    }

    /**
     * Accessory piece
     *
     * Allows access to the value of the piece in the given position.
     *
     * @param pos is a position on the board
     * @return the piece on the given position
     * @throw pos if the position is not on the board
     */
    public Piece getPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau!!!  ");
        }
        return squares[pos.getRow()][pos.getColumn()].getPiece();
    }

    /**
     * drop piece
     *
     * Allows remove the piece at a given position.
     *
     * @param pos is a position
     * @throw pos if the position is not on the board
     */
    public void dropPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau!!!  ");
        }
        this.squares[pos.getRow()][pos.getColumn()].setPiece(null);

    }

    /**
     * free position
     *
     * @param pos is a position
     * @return true if the given position is free and false if the given
     * position is not free
     * @throw pos if the position is not on the board
     */
    public boolean isFree(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau!!!  ");
        }

        return squares[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * Contains opposite color
     *
     * Checks if the box at the given postion contains the piece of the opposite
     * color.
     *
     * @param pos is a position on the board
     * @param col is a color on the board
     * @return true if the box contains a piece opposite color than those passed
     * in parameter and if the box doesn't contain a piece opposite color than
     * those passed in parameter
     * @throw pos if the position is not on the board
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau!!!  ");

        }
        boolean oppositeColor = false;
        if (!isFree(pos)) {

            oppositeColor = squares[pos.getRow()][pos.getColumn()].
                    getPiece().getColor() == col.opposite();
        }
        return oppositeColor;

    }

    /**
     * Position occupied by the player
     *
     *
     * @param player is a color player
     * @return the list of all positions occupied by the given player
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> joueurOccupe = new ArrayList();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                Position pos = new Position(i, j);
                if ((!isFree(pos)) && squares[i][j].getPiece().getColor() == player.getColor()) {
                    joueurOccupe.add(pos);
                }

            }

        }

        return joueurOccupe;
    }

    /**
     * Equals
     *
     * Allows to compare if the two objects are equals.
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
        final Board other = (Board) obj;
        if (!Arrays.deepEquals(this.squares, other.squares)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Arrays.deepHashCode(this.squares);
        return hash;
    }

}
