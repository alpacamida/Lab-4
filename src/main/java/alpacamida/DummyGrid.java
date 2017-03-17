package alpacamida;

public class DummyGrid {

    public static void main(String[] args) {
        GridSetup gridsetup = new GridSetup("gridtest1.txt");
        int row = gridsetup.getDimension().row;
        int col = gridsetup.getDimension().col;
        Grid grid = new Grid(row, col);
        EastWestController east = new EastWestController(grid);


        SharedCar carx = new SharedCar(east, grid);
        Coord[] cary = gridsetup.getRobocars();
        for (int i = 0; i < cary.length; ++i) {
            grid.addCar(carx, cary[i]);
        }


        Obstacle obstaclex = new Obstacle();
        Coord[] obstacley = gridsetup.getObstacles();
        for (int i = 0; i < obstacley.length; ++i) {
            grid.addObstacle(obstaclex, obstacley[i]);

        }

        Rider riderx = new Rider();
        Coord ridery = gridsetup.getRider();
        grid.addRider(riderx, ridery);

        System.out.print(grid.toString());

    }
}
