public class DummyGrid extends Grid {
    public DummyGrid(GridSetup setup) {
        super(setup.getDimension().row, setup.getDimension().col);

        for (Coord c : setup.getRobocars()) {
            SharedCar carx = new SharedCar(new DummyController(this), this);
            addCar(carx, c);
        }

        for (Coord c : setup.getObstacles()) {
            Obstacle obstaclex = new Obstacle();
            addObstacle(obstaclex, c);

        }

        Rider riderx = new Rider();
        Coord ridery = setup.getRider();
        addRider(riderx, ridery);
    }
}
