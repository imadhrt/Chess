package g58132.chess.model;

import g58132.chess.model.pieces.Pawn;
import g58132.chess.model.pieces.Piece;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    //test position initial(getRow=1)
    @Test
    public void testGet2CaseDevantVideColonne0() {
        Position position = new Position(1, 0);
        Piece piece = new Pawn(Color.WHITE);
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
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2CaseDevantVideColonne2() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(3, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2CaseDevantVideColonne3() {
        Position position = new Position(1, 3);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(3, 3)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2CaseDevantVideColonne4() {
        Position position = new Position(1, 4);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 4),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2CaseDevantVideColonne5() {
        Position position = new Position(1, 5);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 5),
                new Position(3, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2CaseDevantVideColonne6() {
        Position position = new Position(1, 6);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 6),
                new Position(3, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2CaseDevantVideColonne7() {
        Position position = new Position(1, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 7),
                new Position(3, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPionAdeverseDevant() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 2);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2PionsAdversesDevantMoi() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 2);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(3, 2);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1PionDevantMoiEquipier() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 2);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2PionsDevantMoiEquipier() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 2);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(3, 2);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2pionEquipierEnDiagonal() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 1);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(3, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2pionEquipierEnDiagonalEt1PionDevantMoi() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 1);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(2, 2);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2pionEquipierEnDiagonalEt1Pion2CaseDevantMoi() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 1);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(3, 2);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(2, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void testGet2pionsAdversaireEnDiagonal() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 1);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 3);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(3, 2),
                new Position(2, 1),
                new Position(2, 3)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionsAdversaireEnDiagonalAuBordDuTableauColonne0() {
        Position position = new Position(1, 0);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 1);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 0),
                new Position(3, 0),
                new Position(2, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionsAdversaireEnDiagonalAuBordDuTableauColonne7() {
        Position position = new Position(1, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 6);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 7),
                new Position(3, 7),
                new Position(2, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionsAdversaireEnDiagonalEt2PionDevantMoi() {
        Position position = new Position(1, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 6);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 7);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(3, 7);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(2, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionAdverseDevantMoi() {
        Position position = new Position(1, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 7);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionAdverse2CaseDevantMoi() {
        Position position = new Position(1, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(3, 7);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //test other  position (getRow !=1)
    @Test
    public void testGet1pionAdverseMilieu() {
        Position position = new Position(4, 4);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 5);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(5, 4),
                new Position(5, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionBordDuTableauLigne7Col7() {
        Position position = new Position(7, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionBordDuTableauLigne0Col() {
        Position position = new Position(7, 0);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet2pionAdverseDiagonalEt1pionAdverseDevantMoi() {
        Position position = new Position(4, 6);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 7);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(5, 5);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(5, 6);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(5, 5),
                new Position(5, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionAdverseDiagonalEt1pionAdverseDevantMoiBord() {
        Position position = new Position(5, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(6, 7);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(6, 6);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(6, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1pionEqupierDiagonalEt1pionEquipierDevantMoiBord() {
        Position position = new Position(5, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(6, 7);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(6, 6);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGet1PionAdverseDigonalEtLibreDevantMoi() {
        Position position = new Position(6, 4);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(7, 3);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(7, 5);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(7, 3),
                new Position(7, 5),
                new Position(7, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //test all the possibilities of the Black pawns 
    //test position initial(getRow=6)
    @Test
    public void testsGet2CaseDevantVideColonne0() {
        Position position = new Position(6, 0);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 0),
                new Position(4, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne1() {
        Position position = new Position(6, 1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(4, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne2() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 2),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne3() {
        Position position = new Position(6, 3);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 3),
                new Position(4, 3)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne4() {
        Position position = new Position(6, 4);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 4),
                new Position(4, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne5() {
        Position position = new Position(6, 5);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 5),
                new Position(4, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne6() {
        Position position = new Position(6, 6);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 6),
                new Position(4, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2CaseDevantVideColonne7() {
        Position position = new Position(6, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 7),
                new Position(4, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGetPionAdeverseDevant() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 2);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2PionsAdversesDevantMoi() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 2);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(4, 2);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1PionDevantMoiEquipier() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 2);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2PionsDevantMoiEquipier() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 2);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(4, 2);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2pionEquipierEnDiagonal() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 1);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(5, 3);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(5, 2),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2pionEquipierEnDiagonalEt1PionDevantMoi() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 2);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(5, 1);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(5, 3);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
//teste ne passe pas

    @Test
    public void testsGet2pionEquipierEnDiagonalEt1Pion2CaseDevantMoi() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 1);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(5, 3);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 2);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(5, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);

    }

    @Test
    public void testsGet2pionsAdversaireEnDiagonal() {
        Position position = new Position(6, 2);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 1);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(5, 3);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 2),
                new Position(5, 2),
                new Position(5, 1),
                new Position(5, 3)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionsAdversaireEnDiagonalAuBordDuTableauColonne0() {
        Position position = new Position(6, 0);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 1);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(5, 0),
                new Position(4, 0),
                new Position(5, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void test1Get1pionsAdversaireEnDiagonalAuBordDuTableauColonne7() {
        Position position = new Position(6, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 6);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(4, 7),
                new Position(5, 7),
                new Position(5, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionsAdversaireEnDiagonalEt2PionDevantMoi() {
        Position position = new Position(6, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 6);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(5, 7);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position4 = new Position(4, 7);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(5, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionAdverseDevantMoi() {
        Position position = new Position(6, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(5, 7);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //test qui ne passe pas
    @Test
    public void testsGet1pionAdverse2CaseDevantMoi() {
        Position position = new Position(6, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(4, 7);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(5, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);
        System.out.println(expected);
        System.out.println(positions);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //test other  position (getRow !=6)
    @Test
    public void testsGet1pionAdverseMilieu() {
        Position position = new Position(4, 4);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(3, 3);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(3, 3),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionBordDuTableauLigne0Col0() {
        Position position = new Position(0, 0);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionBordDuTableauLigne0Col7() {
        Position position = new Position(0, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet2pionAdverseDiagonalEt1pionAdverseDevantMoi() {
        Position position = new Position(4, 6);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(3, 7);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(3, 5);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(3, 6);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(3, 5),
                new Position(3, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionAdverseDiagonalEt1pionAdverseDevantMoiBord() {
        Position position = new Position(3, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(2, 7);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 6);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(2, 6)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1pionEqupierDiagonalEt1pionEquipierDevantMoiBord() {
        Position position = new Position(5, 7);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(4, 7);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(4, 6);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testsGet1PionAdverseDigonalEtLibreDevantMoi() {
        Position position = new Position(5, 4);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(4, 3);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(4, 5);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(4, 5),
                new Position(4, 4)
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
