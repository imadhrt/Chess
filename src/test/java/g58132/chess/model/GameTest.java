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
        Position oldPos = new Position(1, 5);
        Position newPos = new Position(2, 5);
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

    /**
     * Test of the Lion Mat.
     */
    @Test
    public void testLionMatKingWhite() {
        System.out.println("testLionMat");
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 6), new Position(3, 6));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(1, 5), new Position(2, 5));
        instance.movePiecePosition(new Position(7, 3), new Position(3, 7));

        GameState expGameState = GameState.CHECK_MATE;
        GameState result = instance.getState();
        assertEquals(expGameState, result);
    }

    /**
     * Test of the Lion Mat black.
     */
    @Test
    public void testLionMatKingBlack() {
        System.out.println("testLionMat");
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 5), new Position(4, 5));
        instance.movePiecePosition(new Position(0, 5), new Position(1, 4));
        instance.movePiecePosition(new Position(6, 6), new Position(4, 6));
        instance.movePiecePosition(new Position(1, 4), new Position(4, 7));

        GameState expGameState = GameState.CHECK_MATE;
        GameState result = instance.getState();
        assertEquals(expGameState, result);
    }

    /**
     * Test of the Check state black.
     */
    @Test
    public void testCheckStateBlack() {
        System.out.println("testCheckState");
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 5), new Position(4, 5));
        instance.movePiecePosition(new Position(0, 3), new Position(4, 7));

        GameState expGameState = GameState.CHECK;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }

    /**
     * Test of the Check state white.
     */
    @Test
    public void testCheckStateWhite() {
        System.out.println("testCheckState");
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 1), new Position(2, 1));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(1, 5), new Position(2, 5));
        instance.movePiecePosition(new Position(7, 3), new Position(3, 7));

        GameState expGameState = GameState.CHECK;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }

    /**
     * Test of the Check state.
     */
    @Test
    public void testPlay() {
        System.out.println("testCheckState");
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 1), new Position(2, 1));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(1, 5), new Position(2, 5));
        instance.movePiecePosition(new Position(7, 3), new Position(3, 7));
        instance.movePiecePosition(new Position(1, 6), new Position(2, 6));

        GameState expGameState = GameState.PLAY;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }
    @Test
    public void testPromotionPionBlanc() {
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 0), new Position(3, 0));
        instance.movePiecePosition(new Position(6, 3), new Position(5, 3));
        instance.movePiecePosition(new Position(3, 0), new Position(4, 0));
        instance.movePiecePosition(new Position(5, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(4, 0), new Position(5, 0));
        instance.movePiecePosition(new Position(4, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(5, 0), new Position(6, 1));
        instance.movePiecePosition(new Position(6, 7), new Position(5, 7));
        instance.movePiecePosition(new Position(6, 1), new Position(7, 0));
          Board board = new Board();
        Position exp = new Position(7, 0);
        Position res = board.pawnWhite();
        assertEquals(exp, res);

        GameState expGameState = GameState.PLAY;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }
    @Test
    public void testNonPromotionPionBlanc() {
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 0), new Position(3, 0));
        instance.movePiecePosition(new Position(6, 3), new Position(5, 3));
        instance.movePiecePosition(new Position(3, 0), new Position(4, 0));
        instance.movePiecePosition(new Position(5, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(4, 0), new Position(5, 0));
        instance.movePiecePosition(new Position(4, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(5, 0), new Position(6, 1));
        instance.movePiecePosition(new Position(6, 7), new Position(5, 7));
        instance.movePiecePosition(new Position(1, 7), new Position(2, 7));
          Board board = new Board();
        Position exp = null;
        Position res = board.pawnWhite();
        assertEquals(exp, res);

        GameState expGameState = GameState.PLAY;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }
    @Test
    public void testNonPromotionPionNoir() {
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 0), new Position(3, 0));
        instance.movePiecePosition(new Position(6, 3), new Position(5, 3));
        instance.movePiecePosition(new Position(3, 0), new Position(4, 0));
        instance.movePiecePosition(new Position(5, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(4, 0), new Position(5, 0));
        instance.movePiecePosition(new Position(4, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(5, 0), new Position(6, 1));
        instance.movePiecePosition(new Position(3,3), new Position(2, 3));
        instance.movePiecePosition(new Position(0, 0), new Position(1, 0));
        instance.movePiecePosition(new Position(2, 3), new Position(1, 2));
        instance.movePiecePosition(new Position(1, 0), new Position(0, 0));
        instance.movePiecePosition(new Position(1, 2), new Position(0, 1));
          Board board = new Board();
        Position exp = null;
        Position res = board.pawnWhite();
        assertEquals(exp, res);

        GameState expGameState = GameState.PLAY;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }
    @Test
    public void teststaleMate() {
        System.out.println("testStaleMate");
        Game instance = new Game();
        instance.start();

     instance.start();
        
        instance.movePiecePosition(new Position(1,4), new Position(2,4));
        instance.movePiecePosition(new Position(6,0), new Position(4,0));
        instance.movePiecePosition(new Position(0,3), new Position(4,7));
        instance.movePiecePosition(new Position(7,0), new Position(5,0));
        instance.movePiecePosition(new Position(4,7), new Position(4,0));
        instance.movePiecePosition(new Position(6,7), new Position(4,7));
        instance.movePiecePosition(new Position(4,0), new Position(6,2));
        instance.movePiecePosition(new Position(5,0), new Position(5,7));
        instance.movePiecePosition(new Position(1,7), new Position(3,7));
        instance.movePiecePosition(new Position(6,5), new Position(5,5));
        instance.movePiecePosition(new Position(6,2), new Position(6,3));
        instance.movePiecePosition(new Position(7,4), new Position(6,5));
        instance.movePiecePosition(new Position(6,3), new Position(6,1));
        instance.movePiecePosition(new Position(7,3), new Position(2,3));
        instance.movePiecePosition(new Position(6,1), new Position(7,1));
        instance.movePiecePosition(new Position(2,3), new Position(6,7));
        instance.movePiecePosition(new Position(7,1), new Position(7,2));
        instance.movePiecePosition(new Position(6,5), new Position(5,6));
        instance.movePiecePosition(new Position(7,2), new Position(5,4));


        GameState expGameState = GameState.STALE_MATE;
        GameState result = instance.getState();

        assertEquals(expGameState, result);
    }


    @Test
    public void testPlayRoiContreRoi() {
        System.out.println("testStaleMate");
        Game instance = new Game();
        instance.start();

        instance.movePiecePosition(new Position(1, 0), new Position(3, 0));
        instance.movePiecePosition(new Position(6, 0), new Position(4, 0));
        instance.movePiecePosition(new Position(1, 1), new Position(3, 1));
        instance.movePiecePosition(new Position(6, 1), new Position(4, 1));
        instance.movePiecePosition(new Position(1, 2), new Position(3, 2));
        instance.movePiecePosition(new Position(6, 2), new Position(4, 2));
        instance.movePiecePosition(new Position(1, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(6, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(1, 5), new Position(3, 5));
        instance.movePiecePosition(new Position(6, 5), new Position(4, 5));
        instance.movePiecePosition(new Position(1, 6), new Position(3, 6));
        instance.movePiecePosition(new Position(6, 6), new Position(4, 6));
        instance.movePiecePosition(new Position(1, 7), new Position(3, 7));
        instance.movePiecePosition(new Position(6, 7), new Position(4, 7));
        instance.movePiecePosition(new Position(3, 0), new Position(4, 1));
        instance.movePiecePosition(new Position(4, 0), new Position(3, 1));
        instance.movePiecePosition(new Position(3, 2), new Position(4, 3));
        instance.movePiecePosition(new Position(4, 2), new Position(3, 3));

        instance.movePiecePosition(new Position(3, 4), new Position(4, 5));

        instance.movePiecePosition(new Position(4, 4), new Position(3, 5));

        instance.movePiecePosition(new Position(3, 6), new Position(4, 7));
        instance.movePiecePosition(new Position(4, 6), new Position(3, 7));
        instance.movePiecePosition(new Position(0, 0), new Position(7, 0));

        instance.movePiecePosition(new Position(7, 7), new Position(4, 7));

        instance.movePiecePosition(new Position(7, 0), new Position(7, 1));

        instance.movePiecePosition(new Position(4, 7), new Position(4, 5));

        instance.movePiecePosition(new Position(7, 1), new Position(7, 2));
        instance.movePiecePosition(new Position(4, 5), new Position(4, 3));

        instance.movePiecePosition(new Position(7, 2), new Position(7, 3));

        instance.movePiecePosition(new Position(7, 4), new Position(6, 4));

        instance.movePiecePosition(new Position(7, 3), new Position(7, 5));

        instance.movePiecePosition(new Position(4, 3), new Position(4, 1));

        instance.movePiecePosition(new Position(7, 5), new Position(7, 6));

        instance.movePiecePosition(new Position(4, 1), new Position(4, 2));

        instance.movePiecePosition(new Position(7, 6), new Position(3, 6));

        instance.movePiecePosition(new Position(4, 2), new Position(0, 2));

        instance.movePiecePosition(new Position(3, 6), new Position(3, 7));
        instance.movePiecePosition(new Position(0, 2), new Position(0, 1));
        instance.movePiecePosition(new Position(3, 7), new Position(3, 5));
        instance.movePiecePosition(new Position(0, 1), new Position(0, 3));
        instance.movePiecePosition(new Position(0, 4), new Position(1, 4));
        instance.movePiecePosition(new Position(0, 3), new Position(0, 5));
        instance.movePiecePosition(new Position(3, 5), new Position(3, 3));
        instance.movePiecePosition(new Position(0, 5), new Position(0, 6));
        instance.movePiecePosition(new Position(3, 3), new Position(3, 1));
        instance.movePiecePosition(new Position(0, 6), new Position(0, 7));
        instance.movePiecePosition(new Position(3, 1), new Position(3, 7));
        instance.movePiecePosition(new Position(0, 7), new Position(3, 7));
        instance.movePiecePosition(new Position(1, 4), new Position(2, 4));
        instance.movePiecePosition(new Position(3, 7), new Position(3, 4));
        instance.movePiecePosition(new Position(2, 4), new Position(3, 4));
        GameState expGameState = GameState.PLAY;
        GameState result = instance.getState();
        assertEquals(expGameState, result);
    }
    @Test
    public void testMovePiecePosition(){
   
        System.out.println("movePiecePosition");
         Board board = new Board();
        Piece instance = new Pawn(Color.WHITE);
          Position position2 = new Position(6,0 );
          board.setPiece(instance, position2);
      
        Position oldPos = new Position(6, 0);
        Position newPos =new Position(7, 0);
        Game game = new Game();
        game.movePiecePosition(oldPos, newPos);

    }
    

}
