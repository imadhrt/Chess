
package g58132.chess.main;

import g58132.chess.controller.Controller;
import g58132.chess.model.Game;
import g58132.chess.model.Model;
import g58132.chess.view.TextView;

/**
 * launching of the game
 *
 * @author elhar
 */
public class main {

    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }
    
    

}
