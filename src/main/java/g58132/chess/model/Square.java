package g58132.chess.model;

/**
 * Represents one of the sixty-four on the board.
 *
 * @author elhar
 */
public class Square {

    private Piece piece;

    /**
     * Constructor of the Square
     *
     * Allows to initialize the piece attributes to values.
     *
     * @param piece is a pawn
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /**
     * Accessor of piece
     *
     * Allows access to the value of the piece attribute.
     *
     * @return the value of the piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Mutator of the piece
     *
     * Allows to modify the state of the piece
     *
     * @param piece is a pawn
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Check free box
     *
     * @return true if the box is empty (null) and false if the box is not empty
     */
    public boolean isFree() {
        return (this == null);
    }

}
