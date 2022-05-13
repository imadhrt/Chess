
package g58132.chess.model;

import g58132.chess.model.pieces.Pawn;
import g58132.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elhar
 */
public class BoardTest {

    private Board board;

    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        board = new Board();
    }

    // **************** testContains *****************
    @Test
    public void testContainsOnCorner() {
        // A corner of the board
        Position pos = new Position(0, 0);
        assertTrue(board.contains(pos));
    }

    @Test
    public void testContainsMiddleBoard() {
        // A point on the midle of the board
        Position pos = new Position(4, 4);
        assertTrue(board.contains(pos));
    }

    @Test
    public void testContainsRowOutOfRange() {
        // Row out of range
        Position pos = new Position(-1, 3);
        assertFalse(board.contains(pos));
    }

    @Test
    public void testContainsColOutOfRange() {
        // Col. out of range
        Position pos = new Position(1, 8);
        assertFalse(board.contains(pos));
    }

    @Test
    public void testContainsColAndRowOutOfRange() {
        // Row and col. out of range
        Position pos = new Position(10, 10);
        assertFalse(board.contains(pos));
    }

    // ************** testIsFree ****************
    @Test
    public void testIsFreePositionNotFree() {
        // When a piece is on the given positon
        Position pos = new Position(1, 1);
        board.setPiece(new Pawn(Color.BLACK), pos);

        assertFalse(board.isFree(pos));
    }

    @Test
    public void testIsFreePositionIsFree() {
        // When a piece is NOT on the given positon
        Position pos = new Position(3, 2);

        assertTrue(board.isFree(pos));
    }

    // ************** testContainsOppositeColor ****************
    @Test
    public void testContainsOppositeColorNoPiece() {
        // When the position contains no piece at all
        Position pos = new Position(4, 4);
        assertFalse(board.containsOppositeColor(pos, Color.BLACK));
    }

    @Test
    public void testContainsOppositeColorSameColorBlack() {
        // When the position contains a piece of the same color (black)
        Position pos = new Position(2, 5);
        board.setPiece(new Pawn(Color.BLACK), pos);
        assertFalse(board.containsOppositeColor(pos, Color.BLACK));
    }

    @Test
    public void testContainsOppositeColorSameColorWhite() {
        // When the position contains a piece of the same color (white)
        Position pos = new Position(7, 7);
        board.setPiece(new Pawn(Color.WHITE), pos);
        assertFalse(board.containsOppositeColor(pos, Color.WHITE));
    }

    @Test
    public void testContainsOppositeColorOppositeColorWB() {
        // When the position contains a piece of the opposite color 
        // White and black
        Position pos = new Position(7, 7);
        board.setPiece(new Pawn(Color.WHITE), pos);
        assertTrue(board.containsOppositeColor(pos, Color.BLACK));
    }

    @Test
    public void testContainsOppositeColorOppositionColorBW() {
        // When the position contains a piece of the opposite color 
        // black and white
        Position pos = new Position(7, 7);
        board.setPiece(new Pawn(Color.BLACK), pos);
        assertTrue(board.containsOppositeColor(pos, Color.WHITE));
    }

    // ************** testGetPositionOccupiedBy ****************
    @Test
    public void testGetPositionOccupiedByWhiteInitialPosition() {

        Color color = Color.WHITE;
        Player player = new Player(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            board.setPiece(new Pawn(color), new Position(1, i));
            expected.add(new Position(1, i));
        }

        positions = board.getPositionOccupiedBy(player);

        assertEqualsIgnoringOrder(positions, expected);
    }

    @Test
    public void testGetPositionOccupiedByWhiteRandomPositions() {

        Color color = Color.WHITE;
        Player player = new Player(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();

        board.setPiece(new Pawn(color), new Position(2, 0));
        expected.add(new Position(2, 0));

        board.setPiece(new Pawn(color), new Position(3, 2));
        expected.add(new Position(3, 2));

        board.setPiece(new Pawn(color), new Position(5, 5));
        expected.add(new Position(5, 5));

        positions = board.getPositionOccupiedBy(player);

        /* Test if the two lists contain exactly the same elements,
        independently of the order of the elements. */
        assertEqualsIgnoringOrder(positions, expected);
    }

    @Test
    public void testGetPositionOccupiedByBlackInitialPositions() {

        Color color = Color.BLACK;
        Player player = new Player(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            board.setPiece(new Pawn(color), new Position(6, i));
            expected.add(new Position(6, i));
        }

        positions = board.getPositionOccupiedBy(player);

        /* Test if the two lists contain exactly the same elements,
        independently of the order of the elements. */
        assertEqualsIgnoringOrder(positions, expected);
    }

    @Test
    public void testGetPositionOccupiedByBlackRandomPositions() {

        Color color = Color.BLACK;
        Player player = new Player(color);
        List<Position> positions;
        List<Position> expected = new ArrayList<>();

        board.setPiece(new Pawn(color), new Position(0, 0));
        expected.add(new Position(0, 0));

        board.setPiece(new Pawn(color), new Position(1, 1));
        expected.add(new Position(1, 1));

        board.setPiece(new Pawn(color), new Position(6, 7));
        expected.add(new Position(6, 7));

        board.setPiece(new Pawn(color), new Position(1, 7));
        expected.add(new Position(1, 7));

        positions = board.getPositionOccupiedBy(player);

        assertEqualsIgnoringOrder(positions, expected);
    }

    @Test
    public void testGetPositionOccupiedByBlackNoPositions() {

        Color color = Color.BLACK;
        Player player = new Player(color);
        List<Position> positions;

        positions = board.getPositionOccupiedBy(player);

        assertTrue(positions.isEmpty());
    }

    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

    /**
     * Test of contains method, of class Board.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Position pos = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.contains(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInitialPawnRow method, of class Board.
     */
    @Test
    public void testGetInitialPawnRow() {
        System.out.println("getInitialPawnRow");
        Color color = null;
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getInitialPawnRow(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPiece method, of class Board.
     */
    @Test
    public void testSetPiece() {
        System.out.println("setPiece");
        Piece piece = null;
        Position position = null;
        Board instance = new Board();
        instance.setPiece(piece, position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPiece method, of class Board.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Position pos = null;
        Board instance = new Board();
        Piece expResult = null;
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropPiece method, of class Board.
     */
    @Test
    public void testDropPiece() {
        System.out.println("dropPiece");
        Position pos = null;
        Board instance = new Board();
        instance.dropPiece(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFree method, of class Board.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Position pos = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsOppositeColor method, of class Board.
     */
    @Test
    public void testContainsOppositeColor() {
        System.out.println("containsOppositeColor");
        Position pos = null;
        Color col = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.containsOppositeColor(pos, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionOccupiedBy method, of class Board.
     */
    @Test
    public void testGetPositionOccupiedBy() {
        System.out.println("getPositionOccupiedBy");
        Player player = null;
        Board instance = new Board();
        List<Position> expResult = null;
        List<Position> result = instance.getPositionOccupiedBy(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPiecePosition method, of class Board.
     */
    @Test
    public void testGetPiecePosition() {
        System.out.println("getPiecePosition");
        Piece piece = null;
        Board instance = new Board();
        Position expResult = null;
        Position result = instance.getPiecePosition(piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pawnBlack method, of class Board.
     */
    @Test
    public void testPawnBlack() {
        System.out.println("pawnBlack");
        Board instance = new Board();
        Position expResult = new Position(7, 0);
        Position result = instance.pawnBlack();
        assertEquals(expResult, result);
    }

    /**
     * Test of pawnWhite method, of class Board.
     */
    @Test
    public void testPawnWhite() {
        System.out.println("pawnWhite");
        Board instance = new Board();
        Position expResult = null;
        Position result = instance.pawnWhite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Board.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Board.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
