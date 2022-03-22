package g58132.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elhar
 */
public class PositionTest {

    @Test
    public void testNextCaseDirectionCaseNW() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NW);
        Position expResult = new Position(5, 3);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseN() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.N);
        Position expResult = new Position(5, 4);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseNE() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NE);
        Position expResult = new Position(5, 5);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseW() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.W);
        Position expResult = new Position(4, 3);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseE() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.E);
        Position expResult = new Position(4, 5);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseSW() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SW);
        Position expResult = new Position(3, 3);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseS() {
        System.out.println("next");
        Position position1 = new Position(5, 4);
        Position position2 = position1.next(Direction.S);
        Position expResult = new Position(4, 4);
        assertEquals(expResult, position2);

    }

    @Test
    public void testNextCaseDirectionCaseSE() {
        System.out.println("next");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SE);
        Position expResult = new Position(3, 5);
        assertEquals(expResult, position2);

    }

}
