package g58132.chess.controller;

import g58132.chess.model.Model;
import g58132.chess.model.Position;
import g58132.chess.view.View;

/**
 * represents the links between the view and the model
 *
 * @author elhar
 */
public class Controller {

    private Model game;
    private View view;

    /**
     * Constructor of Controller
     *
     * Allows to initialise the Controller with attribute of model and view.
     *
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.game = model;
        this.view = view;

    }

    /**
     * allows to control the game
     */
    public void play() {
        boolean gameIsOver = false;

        view.displayTitle();
        game.start();

        while (!gameIsOver) {
            view.displayBoard();
            view.displayPlayer();
            System.out.println("Entrez une position de DEPART");
            Position oldPosition = view.askPosition();

            System.out.println("Entrez la position d'ARRIVER");
            Position newPosition = view.askPosition();
            try {

                game.movePiecePosition(oldPosition, newPosition);
            } catch (Exception e) {

                view.displayError(e.getMessage());
            }

            if (game.isGameOver()) {
                gameIsOver = true;
            }

        }
        view.displayWinner();
    }

}
