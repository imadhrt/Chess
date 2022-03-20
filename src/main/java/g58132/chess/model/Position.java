package g58132.chess.model;

/**
 * Represent the position on the game board
 *
 * @author elhar
 */
public class Position {

    private int row;
    private int column;

    /**
     * Constructor of position
     *
     * Allows to initialize the row and column attributes to values
     *
     * @param row is a position in the board
     * @param column is a position in the board
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Accessor of row
     *
     * Allows access to the value of the row attribute.
     *
     * @return the value of the row attribute
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Accessor of column
     *
     * Allows access to the value of the column attribute.
     *
     * @return the value of the column attribute
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * New position oh the piece
     *
     * @param dir is the direction of the piece
     *
     * @return a new position on the board
     */
    public Position next(Direction dir) {

        return new Position(this.row + dir.getDeltaRow(), this.column + dir.getDeltaColumn());
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
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

}
