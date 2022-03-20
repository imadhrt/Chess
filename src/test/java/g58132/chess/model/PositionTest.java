package g58132.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elhar
 */
public class PositionTest {

    @Test
    public void testNextCaseDirectionNW() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NW);
        Position expResult = new Position(5, 3);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionN() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.N);
        Position expResult = new Position(5, 4);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionNE() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NE);
        Position expResult = new Position(5, 5);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionW() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.W);
        Position expResult = new Position(4, 3);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionE() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.E);
        Position expResult = new Position(4, 5);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionSW() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SW);
        Position expResult = new Position(3, 3);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionS() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.S);
        Position expResult = new Position(3, 4);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionSE() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SE);
        Position expResult = new Position(3, 5);
        assertEquals(expResult, position2);

    }

}
