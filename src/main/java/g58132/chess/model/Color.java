
package g58132.chess.model;

/**
 *
 * Represents the color(black, white) of a player, of a square, or on a piece of
 * the chess game.
 *
 * @author elhar
 */
public enum Color {
    WHITE, BLACK;

    /**
     * Color opposite
     *
     * Allows to give the opposite color
     *
     * @return black if the current color is white and white if the current is
     * black
     */
    public Color opposite() {
        return (this == WHITE) ? BLACK : WHITE;
    }

}
