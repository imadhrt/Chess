/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
        Position pos = null;
        Game instance = new Game();
        Piece expResult = null;
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
        Player expResult = null;
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
        Player expResult = null;
        Player result = instance.getOppositePlayer();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isCurrentPlayerPosition method, of class Game.
     */
    @Test
    public void testIsCurrentPlayerPosition() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = null;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of movePiecePosition method, of class Game.
     */
    @Test
    public void testMovePiecePosition() {
        System.out.println("movePiecePosition");
        Position oldPos = null;
        Position newPos = null;
        Game instance = new Game();
        instance.movePiecePosition(oldPos, newPos);
     
    }

    /**
     * Test of isGameOver method, of class Game.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        Game instance = new Game();
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
        Position position = null;
        Game instance = new Game();
        List<Position> expResult = null;
        List<Position> result = instance.getPossibleMoves(position);
        assertEquals(expResult, result);
      
    }

    
}
