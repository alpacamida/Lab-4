import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyGridTest {
    @Test
    public void addCarTest() throws Exception {
        Grid grid = new Grid(5, 5);
        SharedCar car1 = new SharedCar(new DummyController(grid), grid);
        grid.addCar(car1, new Coord(1, 1));
        assertEquals(car1.getLocation(), new Coord(1, 1));
    }

    @Test
    public void toStringTest() throws Exception {
        GridSetup gridsetup = new GridSetup(getClass().getResource("gridtest1.txt").getFile() );
        Grid grid = new DummyGrid(gridsetup);

        assertEquals(grid.toString(),
                "==========\n" +
                        "          \n" +
                        " R        \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "      C   \n" +
                        "          \n" +
                        "  #       \n" +
                        "          \n" +
                        "          \n" +
                        "==========");
    }

}
