package g58132.chess.model;

/**
 * Represents the direction of a piece on the board.
 *
 * @author elhar
 */
public enum Direction {
    NW(1, -1),
    N(1, 0),
    NE(1, 1),
    W(0, -1),
    E(0, 1),
    SW(-1, -1),
    S(-1, 0),
    SE(-1, 1);
    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Constructor of Direction
     *
     * Allows to initialize the deltarow and deltacolumn attributes to values.
     *
     * @param deltaRow is a deltaRow in the board
     * @param deltaColumn is a deltaColumn in the board
     */
    private Direction(int deltaR, int deltaC) {
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }

    /**
     * Accessory of deltaRow
     *
     * Allows access to the value of the deltarow attribute.
     *
     * @return the value of the deltaRow attribute
     */
    public int getDeltaRow() {
        return this.deltaRow;
    }

    /**
     * Accessory of deltaColumn
     *
     * Allows access to the value of the deltaColumn attribute.
     *
     * @return the value of the deltaColumn attribute
     */
    public int getDeltaColumn() {
        return this.deltaColumn;
    }

}
