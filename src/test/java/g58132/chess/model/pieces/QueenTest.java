
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
public class QueenTest {

    public QueenTest() {
    }

    /**
     * Test of getPossibleMoves method, of class Queen.
     */
    
    //Black queen
    @Test
    public void testGetPossibleMovesCasGénéral() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Queen queen = new Queen(Color.BLACK);
        board.setPiece(queen, position);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0));
        List<Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesPieceAdverseEstEtOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 2),
                new Position(3, 4),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPieceEquippierEstEtOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPieceEquipierEstOuestSudNord() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 3);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece1.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesAucunDeplacementBloquée() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 3);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);
        Position position5 = new Position(2, 2);
        Piece piece5 = new Queen(Color.BLACK);
        board.setPiece(piece5, position5);
        Position position6 = new Position(4, 4);
        Piece piece6 = new Queen(Color.BLACK);
        board.setPiece(piece6, position6);
        Position position7 = new Position(4, 2);
        Piece piece7 = new Queen(Color.BLACK);
        board.setPiece(piece7, position7);
        Position position8 = new Position(2, 4);
        Piece piece8 = new Queen(Color.BLACK);
        board.setPiece(piece8, position8);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBloqueParPionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 3);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);
        Position position5 = new Position(2, 2);
        Piece piece5 = new Queen(Color.WHITE);
        board.setPiece(piece5, position5);
        Position position6 = new Position(4, 4);
        Piece piece6 = new Queen(Color.WHITE);
        board.setPiece(piece6, position6);
        Position position7 = new Position(4, 2);
        Piece piece7 = new Queen(Color.WHITE);
        board.setPiece(piece7, position7);
        Position position8 = new Position(2, 4);
        Piece piece8 = new Queen(Color.WHITE);
        board.setPiece(piece8, position8);

        List<Position> expected = List.of(
                new Position(3, 2),
                new Position(3, 4),
                new Position(2, 3),
                new Position(4, 3),
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
        Queen queen = new Queen(Color.BLACK);
        board.setPiece(queen, position);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7),
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeCoinBloquéeParPionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.BLACK);
        board.setPiece(queen, position);

        Position position2 = new Position(1, 0);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 1);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(0, 1);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(0, 1),
                new Position(1, 0)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeCoinAucunDeplacement() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.BLACK);
        board.setPiece(queen, position);

        Position position2 = new Position(1, 0);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 1);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(0, 1);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);
        List<Position> expResult = List.of();
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeCoinbloquéePar1PionAdverseEt1pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.BLACK);
        board.setPiece(queen, position);

        Position position2 = new Position(1, 0);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 1);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expResult = List.of(
                new Position(1, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesDansLeBord() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 0);
        Queen queen = new Queen(Color.BLACK);
        board.setPiece(queen, position);
        List<Position> expResult = List.of(
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 3),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0),
                new Position(2, 1),
                new Position(1, 2),
                new Position(0, 3),
                new Position(4, 1),
                new Position(5, 2),
                new Position(6, 3),
                new Position(7, 4)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesPieceDansLeBordBloquéePionEquipier() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(2, 0);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(3, 1);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 1);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);
        Position position5 = new Position(4, 0);
        Piece piece5 = new Queen(Color.BLACK);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    //White queen

    @Test
    public void testGetPossibleMovesPieceDansLeBordBloquéePionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position1 = new Position(2, 0);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);

        Position position3 = new Position(3, 1);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);

        Position position4 = new Position(4, 1);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);

        Position position5 = new Position(4, 0);
        Piece piece5 = new Queen(Color.WHITE);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(2, 0),
                new Position(2, 1),
                new Position(3, 1),
                new Position(4, 1),
                new Position(4, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPieceDansLeBordPionEquipierPionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Queen(Color.BLACK);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);

        Position position3 = new Position(3, 1);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);

        Position position4 = new Position(4, 1);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(3, 1),
                new Position(4, 1),
                new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testsGetPossibleMovesCasGénéral() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 3);
        Queen queen = new Queen(Color.WHITE);
        board.setPiece(queen, position);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0));
        List<Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesPieceAdverseEstEtOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 2),
                new Position(3, 4),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void tesstGetPossibleMovesPieceEquippierEstEtOuest() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesPieceEquipierEstOuestSudNord() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 3);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(1, 1),
                new Position(0, 0),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece1.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesAucunDeplacementBloquée() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 3);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);
        Position position5 = new Position(2, 2);
        Piece piece5 = new Queen(Color.WHITE);
        board.setPiece(piece5, position5);
        Position position6 = new Position(4, 4);
        Piece piece6 = new Queen(Color.WHITE);
        board.setPiece(piece6, position6);
        Position position7 = new Position(4, 2);
        Piece piece7 = new Queen(Color.WHITE);
        board.setPiece(piece7, position7);
        Position position8 = new Position(2, 4);
        Piece piece8 = new Queen(Color.WHITE);
        board.setPiece(piece8, position8);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesBloqueParPionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(3, 2);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 3);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);
        Position position5 = new Position(2, 2);
        Piece piece5 = new Queen(Color.BLACK);
        board.setPiece(piece5, position5);
        Position position6 = new Position(4, 4);
        Piece piece6 = new Queen(Color.BLACK);
        board.setPiece(piece6, position6);
        Position position7 = new Position(4, 2);
        Piece piece7 = new Queen(Color.BLACK);
        board.setPiece(piece7, position7);
        Position position8 = new Position(2, 4);
        Piece piece8 = new Queen(Color.BLACK);
        board.setPiece(piece8, position8);

        List<Position> expected = List.of(
                new Position(3, 2),
                new Position(3, 4),
                new Position(2, 3),
                new Position(4, 3),
                new Position(2, 2),
                new Position(4, 4),
                new Position(4, 2),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void tesstGetPossibleMovesDansLeCoin() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.WHITE);
        board.setPiece(queen, position);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7),
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeCoinBloquéeParPionAdverse() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.WHITE);
        board.setPiece(queen, position);

        Position position2 = new Position(1, 0);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 1);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(0, 1);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(0, 1),
                new Position(1, 0)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeCoinAucunDeplacement() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.WHITE);
        board.setPiece(queen, position);

        Position position2 = new Position(1, 0);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 1);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(0, 1);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);
        List<Position> expResult = List.of();
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeCoinbloquéePar1PionAdverseEt1pionEquipier() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(0, 0);
        Queen queen = new Queen(Color.WHITE);
        board.setPiece(queen, position);

        Position position2 = new Position(1, 0);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 1);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expResult = List.of(
                new Position(1, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesDansLeBord() {
        System.out.println("getPossibleMoves");
        Board board = new Board();
        Position position = new Position(3, 0);
        Queen queen = new Queen(Color.WHITE);
        board.setPiece(queen, position);
        List<Position> expResult = List.of(
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 3),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0),
                new Position(2, 1),
                new Position(1, 2),
                new Position(0, 3),
                new Position(4, 1),
                new Position(5, 2),
                new Position(6, 3),
                new Position(7, 4)
        );
        List< Position> result = queen.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testsGetPossibleMovesPieceDansLeBordBloquéePionEquipier() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(2, 0);
        Piece piece1 = new Queen(Color.WHITE);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(3, 1);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 1);
        Piece piece4 = new Queen(Color.WHITE);
        board.setPiece(piece4, position4);
        Position position5 = new Position(4, 0);
        Piece piece5 = new Queen(Color.WHITE);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesPieceDansLeBordBloquéePionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position1 = new Position(2, 0);
        Piece piece1 = new Queen(Color.BLACK);
        board.setPiece(piece1, position1);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);

        Position position3 = new Position(3, 1);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);

        Position position4 = new Position(4, 1);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);

        Position position5 = new Position(4, 0);
        Piece piece5 = new Queen(Color.BLACK);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(2, 0),
                new Position(2, 1),
                new Position(3, 1),
                new Position(4, 1),
                new Position(4, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPossibleMovesPieceDansLeBordPionEquipierPionAdverse() {
        Board board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 1);
        Piece piece2 = new Queen(Color.WHITE);
        board.setPiece(piece2, position2);

        Position position3 = new Position(3, 1);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece3, position3);

        Position position4 = new Position(4, 1);
        Piece piece4 = new Queen(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(3, 1),
                new Position(4, 1),
                new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0)
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
