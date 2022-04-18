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
public class BishopTest {

    public BishopTest() {
    }

    /**
     * Test of getPossibleMoves method, of class Bishop.
     */
    //Black bishop
    @Test
    public void testGetPossibleMovesCasGénéral() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Bishop bishop = new Bishop(Color.BLACK);
        board.setPiece(bishop, position);
        List<Position> expResult = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0));
        List<Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesPieceAdverseNordEstEtSudOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 4),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPieceEquipierNordEstEtSudOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPieceEquipierNordEstEtSudOuestEtNordOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 2);
        Piece piece3 = new Bishop(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7));

        List<Position> positions = piece1.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesAucunDeplacementBloquée() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 2);
        Piece piece3 = new Bishop(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 4);
        Piece piece4 = new Bishop(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBloqueParPionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 2);
        Piece piece3 = new Bishop(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 4);
        Piece piece4 = new Bishop(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(4, 4),
                new Position(4, 2),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Bishop bishop = new Bishop(Color.BLACK);
        board.setPiece(bishop, position);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeCoinBloquéeParPionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Bishop bishop = new Bishop(Color.BLACK);
        board.setPiece(bishop, position);

        Position position2 = new Position(1, 1);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expResult = List.of(
                new Position(1, 1)
        );
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeCoinAucunDeplacement() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Bishop bishop = new Bishop(Color.BLACK);
        board.setPiece(bishop, position);

        Position position2 = new Position(1, 1);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expResult = List.of();
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeBord() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 0);
        Bishop bishop = new Bishop(Color.BLACK);
        board.setPiece(bishop, position);
        List<Position> expResult = List.of(
                new Position(4, 1),
                new Position(5, 2),
                new Position(6, 3),
                new Position(7, 4),
                new Position(2, 1),
                new Position(1, 2),
                new Position(0, 3)
        );
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesPieceDansLeBordBloquéePionEquipier() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);

        Position position3 = new Position(4, 1);
        Piece piece3 = new Bishop(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //White bishop
    @Test
    public void testsGetPossibleMovesCasGénéral() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Bishop bishop = new Bishop(Color.WHITE);
        board.setPiece(bishop, position);
        List<Position> expResult = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0));
        List<Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesPieceAdverseNordEstEtSudOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 4),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesPieceEquipierNordEstEtSudOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesPieceEquipierNordEstEtSudOuestEtNordOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 2);
        Piece piece3 = new Bishop(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7));

        List<Position> positions = piece1.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesAucunDeplacementBloquée() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 2);
        Piece piece3 = new Bishop(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 4);
        Piece piece4 = new Bishop(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesBloqueParPionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(4, 2);
        Piece piece1 = new Bishop(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 4);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 2);
        Piece piece3 = new Bishop(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 4);
        Piece piece4 = new Bishop(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(4, 4),
                new Position(4, 2),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Bishop bishop = new Bishop(Color.WHITE);
        board.setPiece(bishop, position);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeCoinBloquéeParPionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Bishop bishop = new Bishop(Color.WHITE);
        board.setPiece(bishop, position);

        Position position2 = new Position(1, 1);
        Piece piece2 = new Bishop(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expResult = List.of(
                new Position(1, 1)
        );
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeCoinAucunDeplacement() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Bishop bishop = new Bishop(Color.WHITE);
        board.setPiece(bishop, position);

        Position position2 = new Position(1, 1);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expResult = List.of();
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeBord() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 0);
        Bishop bishop = new Bishop(Color.WHITE);
        board.setPiece(bishop, position);
        List<Position> expResult = List.of(
                new Position(4, 1),
                new Position(5, 2),
                new Position(6, 3),
                new Position(7, 4),
                new Position(2, 1),
                new Position(1, 2),
                new Position(0, 3)
        );
        List< Position> result = bishop.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesPieceDansLeBordBloquéePionEquipier() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Bishop(Color.WHITE);
        board.setPiece(piece2, position2);

        Position position3 = new Position(4, 1);
        Piece piece3 = new Bishop(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

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
