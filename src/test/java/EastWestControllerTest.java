import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rxue
 * @since 3/17/17.
 */
public class EastWestControllerTest {
    @Test
    public void driveTest() throws Exception {
        GridSetup gridsetup = new GridSetup(getClass().getResource("gridtest1.txt").getFile() );
        Grid grid = new DummyGrid(gridsetup);
        EastWestController c = new EastWestController(grid);

        // move east when going south east
        assertEquals(CarController.EAST, c.drive(new Coord(7, 3), new Coord(8, 4)));
        // move east when going north east
        assertEquals(CarController.EAST, c.drive(new Coord(7, 3), new Coord(6, 4)));
        // move east when going east
        assertEquals(CarController.EAST, c.drive(new Coord(7, 3), new Coord(7, 6)));
        // move west when going south west
        assertEquals(CarController.WEST, c.drive(new Coord(7, 5), new Coord(8, 3)));
        // move west when going west
        assertEquals(CarController.WEST, c.drive(new Coord(7, 5), new Coord(7, 3)));
        // move west when going north west
        assertEquals(CarController.WEST, c.drive(new Coord(7, 5), new Coord(6, 4)));
        // move north when going north
        assertEquals(CarController.NORTH, c.drive(new Coord(7, 5), new Coord(0, 5)));
        // move south when going south
        assertEquals(CarController.SOUTH, c.drive(new Coord(7, 5), new Coord(9, 5)));


        // drive north when obstacle on the east and going east
        assertFalse(grid.coordFree(new Coord(7, 2)));
        assertEquals(CarController.NORTH, c.drive(new Coord(7, 1), new Coord(7, 3)));
        // drive north when obstacle on the west and going west
        assertEquals(CarController.NORTH, c.drive(new Coord(7, 3), new Coord(7, 1)));
        // drive east when obstacle on the north and going north
        assertEquals(CarController.EAST, c.drive(new Coord(8, 2), new Coord(6, 2)));
        // drive east when obstacle on the south and going south
        assertEquals(CarController.EAST, c.drive(new Coord(6, 2), new Coord(8, 2)));
    }

}
