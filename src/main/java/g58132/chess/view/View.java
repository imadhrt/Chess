package g58132.chess.view;

import g58132.chess.model.Position;

/**
 *
 * @author elhar
 */
public interface View {

    /**
     * Displays the title and a welcome message to the players.
     */
    public void displayTitle();

    /**
     * Displays the game board.
     */
    public void displayBoard();

    /**
     * Displays the winning player.
     */
    public void displayWinner();

    /**
     * Displays a message inviting the current player (white or black) to play.
     */
    public void displayPlayer();

    /**
     * Requests a valid position on the game board from the user.
     *
     * As long as the user input is not a valid position(row from 1 to 8 and
     * column from 'a' to 'h'
     *
     * @return a valid position
     */
    public Position askPosition();

    /**
     * displays the error message
     *
     * @param message is an error message
     */
    public void displayError(String message);

    /**
     * Displays the message
     *
     * @param message is a message
     */
    public void displayMessage(String message);

    /**
     * Displays the message of StaleMate
     */
    public void displayStaleMate();

    /**
     * Displays the message of CheckMate
     */
    public void displayCheckMate();

    /**
     * Displays the message of Check
     */
    public void displayCheck();

}
