/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elhar
 */
public class FlyingBishopTest {
    
    public FlyingBishopTest() {
    }

    /**
     * Test of getPossibleMoves method, of class FlyingBishop.
     */
    @Test
    public void testGetPossibleMovesCasRegarderFeuille() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 0);
        Board board = new Board();
        FlyingBishop instance = new FlyingBishop(Color.WHITE);
          Position position2 = new Position(2, 2);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
          Position position3 = new Position(3, 3);
        Piece piece3= new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
          Position position4= new Position(4, 4);
        Piece piece4= new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);
          Position position6= new Position(6, 6);
        Piece piece6= new Pawn(Color.BLACK);
        board.setPiece(piece6, position6);
          Position position7= new Position(7, 7);
        Piece piece7= new Rook(Color.WHITE);
        board.setPiece(piece7, position7);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
         assertEqualsIgnoringOrder(expResult, result);
     
    }
    @Test
    public void testGetPossibleMovesCasFlyingBishopPositonRow1Column1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1, 1);
        Board board = new Board();
        FlyingBishop instance = new FlyingBishop(Color.WHITE);
          Position position2 = new Position(2, 2);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
          Position position3 = new Position(3, 3);
        Piece piece3= new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
          Position position4= new Position(4, 4);
        Piece piece4= new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);
          Position position6= new Position(6, 6);
        Piece piece6= new Pawn(Color.BLACK);
        board.setPiece(piece6, position6);
          Position position7= new Position(7, 7);
        Piece piece7= new Rook(Color.WHITE);
        board.setPiece(piece7, position7);
        List<Position> expResult = List.of(
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(2, 0),
                new Position(0, 2)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
         assertEqualsIgnoringOrder(expResult, result);
     
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
