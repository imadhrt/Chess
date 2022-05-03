package g58132.chess.controller;

import g58132.chess.model.GameState;
import g58132.chess.model.Model;
import g58132.chess.model.Position;
import g58132.chess.view.View;

/**
 * represents the links between the view and the model
 *
 * @author elhar
 */
public class Controller {

    private final Model game;
    private final View view;

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
            try {
                view.displayMessage("Saisissez la position DEPART");
                Position oldPosition = view.askPosition();
                if (game.isCurrentPlayerPosition(oldPosition)) {//verifie si position du joueur courant

                    view.displayMessage("Entrez une position d'ARRIVÉE");
                    Position newPosition = view.askPosition();

                    game.movePiecePosition(oldPosition, newPosition);
                    if (game.getState() == GameState.CHECK) {
                        view.displayCheck();
                        
                    }

                }
            } catch (Exception e) {

                view.displayError(e.getMessage());
            }

            if (game.isGameOver()) {
                if (game.getState() == GameState.STALE_MATE) {
                    view.displayStaleMate();

                } else {
                    view.displayCheckMate();

                }
                gameIsOver = true;
            }

        }

        if (game.getState() == GameState.CHECK_MATE) {
            view.displayWinner();
        }
    }

}
