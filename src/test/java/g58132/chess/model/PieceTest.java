/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g58132.chess.model;

//import java.util.List;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elhar
 */
public class PieceTest {
    
    Board board;
    
    public PieceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesP() {
        Position position = new Position(1,1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    
        
    /*********  A vous d'écrire les autres cas.
                Veuillez faire attention à avoir un plan
                de test complet (comme précisé dans l'énoncé)
     ************/
      @Test
    public void testGetPossibleMovesWithoutAnyBlockingParts() {
        Position position = new Position(3,1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(4,1)
                
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
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
    
}



    /**
     * Test of getPossibleMoves method, of class Piece.
     */
//    @Test
//    public void testGetPossibleMoves() {
//        System.out.println("getPossibleMoves");
//        Position position = null;
//        Board board = null;
//        Piece instance = null;
//        List<Position> expResult = null;
//        List<Position> result = instance.getPossibleMoves(position, board);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
