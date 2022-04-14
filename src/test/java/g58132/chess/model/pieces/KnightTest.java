package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Position;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author elhar
 */
public class KnightTest {

    public KnightTest() {
    }

    //test all the possibilities of the white knight
    // white knight
    @Test
    public void testGetPossibleMovesCasGénéralToutEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(2, 4),
                new Position(3, 1),
                new Position(3, 5),
                new Position(5, 1),
                new Position(5, 5),
                new Position(6, 2),
                new Position(6, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesToutAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(2, 2);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(3, 1);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(3, 5);
        Knight instance4 = new Knight(Color.BLACK);
        board.setPiece(instance4, position4);
        Position position5 = new Position(5, 1);
        Knight instance5 = new Knight(Color.BLACK);
        board.setPiece(instance5, position5);
        Position position6 = new Position(5, 5);
        Knight instance6 = new Knight(Color.BLACK);
        board.setPiece(instance6, position6);
        Position position7 = new Position(6, 2);
        Knight instance7 = new Knight(Color.BLACK);
        board.setPiece(instance7, position7);
        Position position8 = new Position(2, 4);
        Knight instance8 = new Knight(Color.BLACK);
        board.setPiece(instance8, position8);
        Position position9 = new Position(6, 4);
        Knight instance9 = new Knight(Color.BLACK);
        board.setPiece(instance9, position9);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(2, 4),
                new Position(3, 1),
                new Position(3, 5),
                new Position(5, 1),
                new Position(5, 5),
                new Position(6, 2),
                new Position(6, 4));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesToutEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(2, 2);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(3, 1);
        Knight instance3 = new Knight(Color.WHITE);
        board.setPiece(instance3, position3);
        Position position4 = new Position(3, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(5, 1);
        Knight instance5 = new Knight(Color.WHITE);
        board.setPiece(instance5, position5);
        Position position6 = new Position(5, 5);
        Knight instance6 = new Knight(Color.WHITE);
        board.setPiece(instance6, position6);
        Position position7 = new Position(6, 2);
        Knight instance7 = new Knight(Color.WHITE);
        board.setPiece(instance7, position7);
        Position position8 = new Position(2, 4);
        Knight instance8 = new Knight(Color.WHITE);
        board.setPiece(instance8, position8);
        Position position9 = new Position(6, 4);
        Knight instance9 = new Knight(Color.WHITE);
        board.setPiece(instance9, position9);
        List<Position> expResult = List.of();

        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMoves4pionAdverseEt4pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(2, 2);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(3, 1);
        Knight instance3 = new Knight(Color.WHITE);
        board.setPiece(instance3, position3);
        Position position4 = new Position(3, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(5, 1);
        Knight instance5 = new Knight(Color.WHITE);
        board.setPiece(instance5, position5);
        Position position6 = new Position(5, 5);
        Knight instance6 = new Knight(Color.BLACK);
        board.setPiece(instance6, position6);
        Position position7 = new Position(6, 2);
        Knight instance7 = new Knight(Color.BLACK);
        board.setPiece(instance7, position7);
        Position position8 = new Position(2, 4);
        Knight instance8 = new Knight(Color.BLACK);
        board.setPiece(instance8, position8);
        Position position9 = new Position(6, 4);
        Knight instance9 = new Knight(Color.BLACK);
        board.setPiece(instance9, position9);
        List<Position> expResult = List.of(
                new Position(2, 4),
                new Position(5, 5),
                new Position(6, 2),
                new Position(6, 4));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2, 1),
                new Position(1, 2)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoinEt2PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(2, 1);
        Piece instance2 = new Pawn(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(1, 2);
        Piece instance3 = new Pawn(Color.WHITE);
        board.setPiece(instance3, position3);
        List<Position> expResult = List.of();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoinEt2PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(2, 1);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(1, 2);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        List<Position> expResult = List.of(
                new Position(2, 1),
                new Position(1, 2));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoinEt1PionAdverseEt1PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(2, 1);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(1, 2);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        List<Position> expResult = List.of(
                new Position(1, 2));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieuToutEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(1, 5),
                new Position(2, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieuTout4PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(1, 1);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(2, 2);
        Knight instance3 = new Knight(Color.WHITE);
        board.setPiece(instance3, position3);
        Position position4 = new Position(1, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(2, 4);
        Knight instance5 = new Knight(Color.WHITE);
        board.setPiece(instance5, position5);
        List<Position> expResult = List.of();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieuTout4PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(1, 1);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(2, 2);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(1, 5);
        Knight instance4 = new Knight(Color.BLACK);
        board.setPiece(instance4, position4);
        Position position5 = new Position(2, 4);
        Knight instance5 = new Knight(Color.BLACK);
        board.setPiece(instance5, position5);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(1, 5),
                new Position(2, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieu2PionAdverse2PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        Knight instance = new Knight(Color.WHITE);
        Position position2 = new Position(1, 1);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(2, 2);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(1, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(2, 4);
        Knight instance5 = new Knight(Color.BLACK);
        board.setPiece(instance5, position5);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(2, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }
    //test all the possibilities of the black knight
    // black knight

    @Test
    public void testsGetPossibleMovesCasGénéralToutEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Knight instance = new Knight(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(1, 2),
                new Position(1, 4),
                new Position(2, 1),
                new Position(2, 5),
                new Position(4, 1),
                new Position(4, 5),
                new Position(5, 2),
                new Position(5, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesToutAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(1, 2);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(2, 1);
        Knight instance3 = new Knight(Color.WHITE);
        board.setPiece(instance3, position3);
        Position position4 = new Position(2, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(4, 1);
        Knight instance5 = new Knight(Color.WHITE);
        board.setPiece(instance5, position5);
        Position position6 = new Position(4, 5);
        Knight instance6 = new Knight(Color.WHITE);
        board.setPiece(instance6, position6);
        Position position7 = new Position(5, 2);
        Knight instance7 = new Knight(Color.WHITE);
        board.setPiece(instance7, position7);
        Position position8 = new Position(5, 4);
        Knight instance8 = new Knight(Color.WHITE);
        board.setPiece(instance8, position8);
        Position position9 = new Position(1, 4);
        Knight instance9 = new Knight(Color.WHITE);
        board.setPiece(instance9, position9);
        List<Position> expResult = List.of(
                new Position(1, 2),
                new Position(1, 4),
                new Position(2, 1),
                new Position(2, 5),
                new Position(4, 1),
                new Position(4, 5),
                new Position(5, 2),
                new Position(5, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesToutEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(1, 2);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(2, 1);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(2, 5);
        Knight instance4 = new Knight(Color.BLACK);
        board.setPiece(instance4, position4);
        Position position5 = new Position(4, 1);
        Knight instance5 = new Knight(Color.BLACK);
        board.setPiece(instance5, position5);
        Position position6 = new Position(4, 5);
        Knight instance6 = new Knight(Color.BLACK);
        board.setPiece(instance6, position6);
        Position position7 = new Position(5, 2);
        Knight instance7 = new Knight(Color.BLACK);
        board.setPiece(instance7, position7);
        Position position8 = new Position(5, 4);
        Knight instance8 = new Knight(Color.BLACK);
        board.setPiece(instance8, position8);
        Position position9 = new Position(1, 4);
        Knight instance9 = new Knight(Color.BLACK);
        board.setPiece(instance9, position9);
        List<Position> expResult = List.of();

        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMoves4pionAdverseEt4pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(1, 2);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(2, 1);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(2, 5);
        Knight instance4 = new Knight(Color.BLACK);
        board.setPiece(instance4, position4);
        Position position5 = new Position(4, 1);
        Knight instance5 = new Knight(Color.BLACK);
        board.setPiece(instance5, position5);
        Position position6 = new Position(4, 5);
        Knight instance6 = new Knight(Color.WHITE);
        board.setPiece(instance6, position6);
        Position position7 = new Position(5, 2);
        Knight instance7 = new Knight(Color.WHITE);
        board.setPiece(instance7, position7);
        Position position8 = new Position(5, 4);
        Knight instance8 = new Knight(Color.WHITE);
        board.setPiece(instance8, position8);
        Position position9 = new Position(1, 4);
        Knight instance9 = new Knight(Color.WHITE);
        board.setPiece(instance9, position9);
        List<Position> expResult = List.of(
                new Position(4, 5),
                new Position(5, 2),
                new Position(5, 4),
                new Position(1, 4)
        );

        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        Knight instance = new Knight(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(6, 5),
                new Position(5, 6)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoinEt2PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(6, 5);
        Piece instance2 = new Pawn(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(5, 6);
        Piece instance3 = new Pawn(Color.BLACK);
        board.setPiece(instance3, position3);
        List<Position> expResult = List.of();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoinEt2PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(6, 5);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(5, 6);
        Knight instance3 = new Knight(Color.WHITE);
        board.setPiece(instance3, position3);
        List<Position> expResult = List.of(
                new Position(6, 5),
                new Position(5, 6));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoinEt1PionAdverseEt1PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(5, 6);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(6, 5);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        List<Position> expResult = List.of(
                new Position(5, 6));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesLigne7EtMilieuToutEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        Knight instance = new Knight(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(6, 1),
                new Position(6, 5),
                new Position(5, 2),
                new Position(5, 4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesLigne7EtMilieuTout4PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(6, 1);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(5, 2);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(6, 5);
        Knight instance4 = new Knight(Color.BLACK);
        board.setPiece(instance4, position4);
        Position position5 = new Position(5, 4);
        Knight instance5 = new Knight(Color.BLACK);
        board.setPiece(instance5, position5);
        List<Position> expResult = List.of();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesLigne7EtMilieuTout4PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(6, 1);
        Knight instance2 = new Knight(Color.WHITE);
        board.setPiece(instance2, position2);
        Position position3 = new Position(5, 2);
        Knight instance3 = new Knight(Color.WHITE);
        board.setPiece(instance3, position3);
        Position position4 = new Position(6, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(5, 4);
        Knight instance5 = new Knight(Color.WHITE);
        board.setPiece(instance5, position5);
        List<Position> expResult = List.of(
                new Position(6, 1),
                new Position(5, 2),
                new Position(6, 5),
                new Position(5, 4)
        );

        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesLigne7EtMilieu2PionAdverse2PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        Knight instance = new Knight(Color.BLACK);
        Position position2 = new Position(6, 1);
        Knight instance2 = new Knight(Color.BLACK);
        board.setPiece(instance2, position2);
        Position position3 = new Position(5, 2);
        Knight instance3 = new Knight(Color.BLACK);
        board.setPiece(instance3, position3);
        Position position4 = new Position(6, 5);
        Knight instance4 = new Knight(Color.WHITE);
        board.setPiece(instance4, position4);
        Position position5 = new Position(5, 4);
        Knight instance5 = new Knight(Color.WHITE);
        board.setPiece(instance5, position5);
        List<Position> expResult = List.of(
                new Position(6, 5),
                new Position(5, 4)
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
