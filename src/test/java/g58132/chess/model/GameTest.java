package g58132.chess.model;

import g58132.chess.model.pieces.Pawn;
import g58132.chess.model.pieces.Piece;
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
        Piece expResult = new Pawn(Color.WHITE);
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
        Player expResult = new Player(Color.WHITE);
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
    public void testIsNotCurrentPlayerPosition() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(6, 1);
        Game instance = new Game();
        instance.start();
        boolean expResult = false;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);

    }

    @Test
    public void testIsCurrentPlayerPosition1() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(1, 1);
        Game instance = new Game();
        instance.start();
        boolean expResult = true;
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
    /**
     * Test of isValidMove method, of class Game.
     */
    @Test
    public void testIsValidMove() {
        System.out.println("isValidMove");
        Position oldPos = new Position(1, 5);//si je bouge de là
        Position newPos = new Position(2, 5);//à là c'est censé me retourner false
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 0), new Position(2, 0));
        instance.movePiecePosition(new Position(6, 4), new Position(5, 4));
        instance.movePiecePosition(new Position(1, 1), new Position(2, 1));
        instance.movePiecePosition(new Position(7, 3), new Position(3, 7));
        boolean expResult = false;
        boolean result = instance.isValidMove(oldPos, newPos);
        assertEquals(expResult, result);
    }

}
