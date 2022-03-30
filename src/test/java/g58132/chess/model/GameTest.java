
package g58132.chess.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elhar
 */
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Game instance = new Game();
        instance.start();
        
        
        
   
    }

    /**
     * Test of getPiece method, of class Game.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Position pos = new Position(1, 0);
        Game instance = new Game();
        instance.start();//place les pieces en ligne
        Piece expResult = new Piece(Color.WHITE);
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test


    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");
        Game instance = new Game();
         instance.start();
        Player expResult = new Player(Color.WHITE) ;
        Player result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getOppositePlayer method, of class Game.
     */
    @Test
    public void testGetOppositePlayer() {
        System.out.println("getOppositePlayer");
        Game instance = new Game();
        instance.start();
        Player expResult = new Player(Color.BLACK);
        Player result = instance.getOppositePlayer();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isCurrentPlayerPosition method, of class Game.
     */
    @Test
    public void testIsCurrentPlayerPosition() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(6, 6);
        Game instance = new Game();
        instance.start();
        boolean expResult = false;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
       
    }


    /**
     * Test of isGameOver method, of class Game.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        Game instance = new Game();
        instance.start();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getPossibleMoves method, of class Game.
     */
    @Test
    public void testGetPossibleMoves() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6, 1);
        Game instance = new Game();
        instance.start();
        List<Position> expResult = List.of(
                new Position(5, 1),
                new Position(4, 1)
        
        );
        List<Position> result = instance.getPossibleMoves(position);
        assertEquals(expResult, result);
      
    }

    
}
