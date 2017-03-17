import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyGrid {
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
        int row = gridsetup.getDimension().row;
        int col = gridsetup.getDimension().col;
        Grid grid = new Grid(row, col);

        for (Coord coord : gridsetup.getRobocars()) {
            SharedCar carx = new SharedCar(new DummyController(grid), grid);
            grid.addCar(carx, coord);
        }
            // FIXME: Compare with the `:` syntax above to iterate an array below
//        Coord[] cary = gridsetup.getRobocars();
//        for (int i = 0; i < cary.length; ++i) {
//            grid.addCar(carx, cary[i]);
//        }


        // FIXME: You call `new Obstacle()` only once for multiple obstacles.
        // i.e `grid.addObstacle(obstaclex, obstacley[i]);` has been called obstacley.length times, all for the same obstaclex
        // Look at example above that you should create a new obstacle each iteration.
        Obstacle obstaclex = new Obstacle();
        // FIXME: Convert this to `:` format yourself
        Coord[] obstacley = gridsetup.getObstacles();
        for (int i = 0; i < obstacley.length; ++i) {
            grid.addObstacle(obstaclex, obstacley[i]);

        }

        Rider riderx = new Rider();
        Coord ridery = gridsetup.getRider();
        grid.addRider(riderx, ridery);


        assertEquals(grid.toString(),
                "==========\n" +
                        "..........\n" +
                        ".R........\n" +
                        "..........\n" +
                        "..........\n" +
                        "..........\n" +
                        "......C...\n" +
                        "..........\n" +
                        "..#.......\n" +
                        "..........\n" +
                        "..........\n" +
                        "==========");
    }

}
