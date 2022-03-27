
package g58132.chess.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
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
    //test all the possibilities of the white pawns
        @Test
    public void testGetPossibleMovesPositionInitialColumn0() {
        Position position = new Position(1, 0);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 0),
                new Position(3, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
//test of the school
    @Test
    public void testGetPossibleMovesP() {
        Position position = new Position(1, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPositionInitialColumn2() {
        Position position = new Position(1, 2);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(3, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPositionInitialColumn3() {
        Position position = new Position(1, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(3, 3)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPositionInitialColumn4() {
        Position position = new Position(1, 4);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 4),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPositionInitialColumn5() {
        Position position = new Position(1, 5);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 5),
                new Position(3, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPositionInitialColumn6() {
        Position position = new Position(1, 6);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 6),
                new Position(3, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPositionInitialColumn7() {
        Position position = new Position(1,7 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 7),
                new Position(3, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesOpposingPawnFrontMePositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,2 );
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
           
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesOpposing2PawnFrontMePositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,2 );
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2,2 );
        Piece piece3 = new Piece(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
           
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPartner1PawnFrontMePositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,2 );
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
       

        List<Position> expected = List.of(
           
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPartner2PawnFrontMePositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,2 );
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(3,2 );
        Piece piece3 = new Piece(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
           
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPartner2PawnDiagonalPositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,1 );
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2,3 );
        Piece piece3 = new Piece(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                
           new Position(2,2),
           new Position(3,2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPartner2PawnDiagonalAndFontMePositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,1 );
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2,3 );
        Piece piece3 = new Piece(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(2,2 );
        Piece piece4 = new Piece(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                
                
         
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesPartner2PawnDiagonalAnd2caseFontMePositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,1 );
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2,3 );
        Piece piece3 = new Piece(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(3,2 );
        Piece piece4 = new Piece(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
               new Position(2,2)
                
         
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesAdversary2PawnDiagonalPositionInitial() {
        Position position = new Position(1,2 );
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2,1 );
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2,3 );
        Piece piece3 = new Piece(Color.BLACK);
        board.setPiece(piece3, position3);
        

        List<Position> expected = List.of(
               new Position(2,2),
               new Position(3,2),
               new Position(2, 1),
               new Position(2, 3)
                
         
        );

        List<Position> positions = piece.getPossibleMoves(position, board);


        assertEqualsIgnoringOrder(expected, positions);
    }
    
    
//    @Test
//    public void testGetPossibleMovesWithoutAnyBlockingParts() {
//        Position position = new Position(0, 2);
//        Piece piece = new Piece(Color.WHITE);
//        board.setPiece(piece, position);
//
//        List<Position> expected = List.of(
//                new Position (1,2)
//        );
//
//        List<Position> positions = piece.getPossibleMoves(position, board);
//       
//
//        assertEqualsIgnoringOrder(expected, positions);
//    }
//    @Test
//    public void testGetPossibleMovesSpawnExtrem() {
//        Position position = new Position(4,3);
//        Piece piece = new Piece(Color.WHITE);
//        board.setPiece(piece, position);
//        Position position2 = new Position(5,2);
//        Piece piece2= new Piece(Color.BLACK);
//        board.setPiece(piece2, position2);
//        Position position3 = new Position(5,3);
//        Piece piece3 = new Piece(Color.BLACK);
//        board.setPiece(piece3, position3);
//
//        List<Position> expected = List.of(
//                new Position(5,2)
//               
//               
//               
//                
//                
//                
//        );
//
//        List<Position> positions = piece.getPossibleMoves(position, board);
//        System.out.println(expected);
//       System.out.println(positions);
//
//           assertEqualsIgnoringOrder(expected, positions);
//    }
      
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

}


