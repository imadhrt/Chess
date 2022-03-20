package g58132.chess.model;

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

}
