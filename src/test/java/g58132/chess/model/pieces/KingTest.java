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
public class KingTest {

    public KingTest() {
    }

    //test all the possibilities of the white king
    // white king
    @Test
    public void testGetPossibleMovesCasGeneralEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        King king = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4),
                new Position(3, 2),
                new Position(3, 4),
                new Position(4, 2),
                new Position(4, 3),
                new Position(4, 4));
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMoves8pionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        King king = new King(Color.WHITE);
        Position position2 = new Position(2, 2);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(2, 3);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(2, 4);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);
        Position position5 = new Position(3, 2);
        King king5 = new King(Color.BLACK);
        board.setPiece(king5, position5);
        Position position6 = new Position(3, 4);
        King king6 = new King(Color.BLACK);
        board.setPiece(king6, position6);
        Position position7 = new Position(4, 2);
        King king7 = new King(Color.BLACK);
        board.setPiece(king7, position7);
        Position position8 = new Position(4, 3);
        King king8 = new King(Color.BLACK);
        board.setPiece(king8, position8);
        Position position9 = new Position(4, 4);
        King king9 = new King(Color.BLACK);
        board.setPiece(king9, position9);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4),
                new Position(3, 2),
                new Position(3, 4),
                new Position(4, 2),
                new Position(4, 3),
                new Position(4, 4));
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMoves8pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        King king = new King(Color.WHITE);
        Position position2 = new Position(2, 2);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(2, 3);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(2, 4);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);
        Position position5 = new Position(3, 2);
        King king5 = new King(Color.WHITE);
        board.setPiece(king5, position5);
        Position position6 = new Position(3, 4);
        King king6 = new King(Color.WHITE);
        board.setPiece(king6, position6);
        Position position7 = new Position(4, 2);
        King king7 = new King(Color.WHITE);
        board.setPiece(king7, position7);
        Position position8 = new Position(4, 3);
        King king8 = new King(Color.WHITE);
        board.setPiece(king8, position8);
        Position position9 = new Position(4, 4);
        King king9 = new King(Color.WHITE);
        board.setPiece(king9, position9);
        List<Position> expResult = List.of();
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMoves4pionEquipierEt4PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        King king = new King(Color.WHITE);
        Position position2 = new Position(2, 2);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(2, 3);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(2, 4);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);
        Position position5 = new Position(3, 2);
        King king5 = new King(Color.BLACK);
        board.setPiece(king5, position5);
        Position position6 = new Position(3, 4);
        King king6 = new King(Color.WHITE);
        board.setPiece(king6, position6);
        Position position7 = new Position(4, 2);
        King king7 = new King(Color.WHITE);
        board.setPiece(king7, position7);
        Position position8 = new Position(4, 3);
        King king8 = new King(Color.WHITE);
        board.setPiece(king8, position8);
        Position position9 = new Position(4, 4);
        King king9 = new King(Color.WHITE);
        board.setPiece(king9, position9);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4),
                new Position(3, 2)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        King king = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1, 0),
                new Position(1, 1),
                new Position(0, 1)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoin3pionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        King king = new King(Color.WHITE);
        Position position2 = new Position(1, 0);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(1, 1);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(0, 1);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);

        List<Position> expResult = List.of(
                new Position(1, 0),
                new Position(1, 1),
                new Position(0, 1));

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoin3pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        King king = new King(Color.WHITE);
        Position position2 = new Position(1, 0);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(1, 1);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(0, 1);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);

        List<Position> expResult = List.of();

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesDansLeCoin2pionEquipierEt1Adverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        King king = new King(Color.WHITE);
        Position position2 = new Position(1, 0);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(1, 1);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(0, 1);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);

        List<Position> expResult = List.of(
                new Position(1, 0));

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieuEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        King king = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(0, 2),
                new Position(1, 2),
                new Position(1, 3),
                new Position(1, 4),
                new Position(0, 4)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieu5PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        King king = new King(Color.WHITE);
        Position position2 = new Position(0, 2);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(1, 2);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(1, 3);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);
        Position position5 = new Position(1, 4);
        King king5 = new King(Color.BLACK);
        board.setPiece(king5, position5);
        Position position6 = new Position(0, 4);
        King king6 = new King(Color.BLACK);
        board.setPiece(king6, position6);
        List<Position> expResult = List.of(
                new Position(0, 2),
                new Position(1, 2),
                new Position(1, 3),
                new Position(1, 4),
                new Position(0, 4)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieu5PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        King king = new King(Color.WHITE);
        Position position2 = new Position(0, 2);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(1, 2);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(1, 3);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);
        Position position5 = new Position(1, 4);
        King king5 = new King(Color.WHITE);
        board.setPiece(king5, position5);
        Position position6 = new Position(0, 4);
        King king6 = new King(Color.WHITE);
        board.setPiece(king6, position6);
        List<Position> expResult = List.of();
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieu2PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 3);
        King king = new King(Color.WHITE);
        Position position2 = new Position(0, 2);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(1, 2);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        List<Position> expResult = List.of(
                new Position(1, 3),
                new Position(1, 4),
                new Position(0, 4)
        );

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    //test all the possibilities of the black king
    // black king
    @Test
    public void testsGetPossibleMovesCasGeneralEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        King king = new King(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(4, 2),
                new Position(3, 2),
                new Position(3, 3),
                new Position(3, 4),
                new Position(4, 4),
                new Position(5, 4),
                new Position(5, 3),
                new Position(5, 2));
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMoves8pionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        King king = new King(Color.BLACK);
        Position position2 = new Position(4, 2);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(3, 2);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(3, 3);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);
        Position position5 = new Position(3, 4);
        King king5 = new King(Color.WHITE);
        board.setPiece(king5, position5);
        Position position6 = new Position(4, 4);
        King king6 = new King(Color.WHITE);
        board.setPiece(king6, position6);
        Position position7 = new Position(5, 4);
        King king7 = new King(Color.WHITE);
        board.setPiece(king7, position7);
        Position position8 = new Position(5, 3);
        King king8 = new King(Color.WHITE);
        board.setPiece(king8, position8);
        Position position9 = new Position(5, 2);
        King king9 = new King(Color.WHITE);
        board.setPiece(king9, position9);
        List<Position> expResult = List.of(
                new Position(4, 2),
                new Position(3, 2),
                new Position(3, 3),
                new Position(3, 4),
                new Position(4, 4),
                new Position(5, 4),
                new Position(5, 3),
                new Position(5, 2));
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMoves8pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        King king = new King(Color.BLACK);
        Position position2 = new Position(4, 2);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(3, 2);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(3, 3);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);
        Position position5 = new Position(3, 4);
        King king5 = new King(Color.BLACK);
        board.setPiece(king5, position5);
        Position position6 = new Position(4, 4);
        King king6 = new King(Color.BLACK);
        board.setPiece(king6, position6);
        Position position7 = new Position(5, 4);
        King king7 = new King(Color.BLACK);
        board.setPiece(king7, position7);
        Position position8 = new Position(5, 3);
        King king8 = new King(Color.BLACK);
        board.setPiece(king8, position8);
        Position position9 = new Position(5, 2);
        King king9 = new King(Color.BLACK);
        board.setPiece(king9, position9);
        List<Position> expResult = List.of();
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMoves4pionEquipierEt4pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(4, 3);
        King king = new King(Color.BLACK);
        Position position2 = new Position(4, 2);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(3, 2);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(3, 3);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);
        Position position5 = new Position(3, 4);
        King king5 = new King(Color.WHITE);
        board.setPiece(king5, position5);
        Position position6 = new Position(4, 4);
        King king6 = new King(Color.BLACK);
        board.setPiece(king6, position6);
        Position position7 = new Position(5, 4);
        King king7 = new King(Color.BLACK);
        board.setPiece(king7, position7);
        Position position8 = new Position(5, 3);
        King king8 = new King(Color.BLACK);
        board.setPiece(king8, position8);
        Position position9 = new Position(5, 2);
        King king9 = new King(Color.BLACK);
        board.setPiece(king9, position9);
        List<Position> expResult = List.of(
                new Position(4, 2),
                new Position(3, 2),
                new Position(3, 3),
                new Position(3, 4)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        King king = new King(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(7, 6),
                new Position(6, 6),
                new Position(6, 7)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoin3pionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        King king = new King(Color.BLACK);
        Position position2 = new Position(7, 6);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(6, 6);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(6, 7);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);

        List<Position> expResult = List.of(
                new Position(7, 6),
                new Position(6, 6),
                new Position(6, 7));

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoin3pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        King king = new King(Color.BLACK);
        Position position2 = new Position(7, 6);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(6, 6);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(6, 7);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);

        List<Position> expResult = List.of();

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesDansLeCoin2pionEquipierEt1Adverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 7);
        King king = new King(Color.BLACK);
        Position position2 = new Position(7, 6);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(6, 6);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(6, 7);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);

        List<Position> expResult = List.of(
                new Position(6, 7));

        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesLigne7EtMilieuEmplacementVide() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        King king = new King(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(7, 2),
                new Position(6, 2),
                new Position(6, 3),
                new Position(6, 4),
                new Position(7, 4)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesLigne7EtMilieu5PionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        King king = new King(Color.BLACK);
        Position position2 = new Position(7, 2);
        King king2 = new King(Color.WHITE);
        board.setPiece(king2, position2);
        Position position3 = new Position(6, 2);
        King king3 = new King(Color.WHITE);
        board.setPiece(king3, position3);
        Position position4 = new Position(6, 3);
        King king4 = new King(Color.WHITE);
        board.setPiece(king4, position4);
        Position position5 = new Position(6, 4);
        King king5 = new King(Color.WHITE);
        board.setPiece(king5, position5);
        Position position6 = new Position(7, 4);
        King king6 = new King(Color.WHITE);
        board.setPiece(king6, position6);
        List<Position> expResult = List.of(
                new Position(7, 2),
                new Position(6, 2),
                new Position(6, 3),
                new Position(6, 4),
                new Position(7, 4)
        );
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testGetPossibleMovesLigne0EtMilieu4PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        King king = new King(Color.BLACK);
        Position position2 = new Position(7, 2);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(6, 2);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        Position position4 = new Position(6, 3);
        King king4 = new King(Color.BLACK);
        board.setPiece(king4, position4);
        Position position5 = new Position(6, 4);
        King king5 = new King(Color.BLACK);
        board.setPiece(king5, position5);
        Position position6 = new Position(7, 4);
        King king6 = new King(Color.BLACK);
        board.setPiece(king6, position6);
        List<Position> expResult = List.of();
        List<Position> result = king.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);

    }

    @Test
    public void testsGetPossibleMovesLigne0EtMilieu2PionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(7, 3);
        King king = new King(Color.BLACK);
        Position position2 = new Position(7, 2);
        King king2 = new King(Color.BLACK);
        board.setPiece(king2, position2);
        Position position3 = new Position(6, 2);
        King king3 = new King(Color.BLACK);
        board.setPiece(king3, position3);
        List<Position> expResult = List.of(
                new Position(6, 3),
                new Position(6, 4),
                new Position(7, 4)
        );

        List<Position> result = king.getPossibleMoves(position, board);
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
