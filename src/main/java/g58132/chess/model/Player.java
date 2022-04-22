package g58132.chess.model;

import java.util.Objects;

/**
 * Represents the color of the player.
 *
 * @author elhar
 */
public class Player {

    private final Color color;

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
     * Accessory of the color
     *
     * Allows access to the value oh the color attribute.
     *
     * @return the color
     */
    public Color getColor() {
        return this.color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.color);
        return hash;
    }

    /**
     * Equals
     *
     * Allows to compare if the two objects are equals.
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
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
