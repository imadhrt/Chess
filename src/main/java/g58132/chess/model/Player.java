package g58132.chess.model;

/**
 *
 * @author elhar
 */
public class Player {

    private Color color;

    /**
     * Constructor of player
     *
     * Inialize un new player of a given color.
     *
     * @param color is a color
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Accessor of the color
     *
     * Allows access to the value oh the color attribute.
     *
     * @return the color
     */

    public Color getColor() {
        return color;
    }

}
