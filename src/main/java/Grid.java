import java.util.ArrayList;

public class Grid implements GridInfo, CoordInfo {
    private int row;
    private int col;
    private GridObject Grid[][];
    private Rider rider;
    private ArrayList<SharedCar> CarArr = new ArrayList<SharedCar>();
    private ArrayList<Obstacle> ObstacleArr = new ArrayList<Obstacle>();

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;
        Grid = new GridObject[row][col];
    }

    public boolean addRider(Rider a, Coord x) {
        if (coordFree(x)) {
            rider = a;
            Grid[x.row][x.col] = a;
            a.setLocation(x);
            toDrive();
            return true;
        } else
            return false;
    }

    public boolean addCar(SharedCar a, Coord x) {
        if (coordFree(x)) {
            CarArr.add(a);
            Grid[x.row][x.col] = a;
            a.setLocation(x);
            return true;
        } else return false;
    }

    public boolean addObstacle(Obstacle a, Coord x) {
        if (coordFree(x)) {
            ObstacleArr.add(a);
            Grid[x.row][x.col] = a;
            a.setLocation(x);
            return true;
        } else return false;
    }

    public boolean toDrive() {
        for (SharedCar car : CarArr) {
            if (rider != null) {
                car.newRider(rider.location);
            }
            car.drive();
        }
        return true;
    }

    public boolean riderLoaded(SharedCar car) {

        if (rider.location.equals(car.location)) {
            rider.pickUp(car);
            rider = null;
            return true;
        }

        return false;
    }

    public boolean claim(SharedCar a, Coord x) {
        if (coordFree(x) || coordRider(x)) {
            Grid[x.row][x.col] = a;
            Grid[a.location.row][a.location.col] = null;
            a.location = x;
            return true;
        } else
            return false;
    }

    public boolean coordFree(Coord loc) {
        if (loc.row < 0 || loc.row > (this.row - 1) || loc.col < 0 || loc.col > (this.col - 1))
            return false;
        else if (Grid[loc.row][loc.col] == null)
            return true;
        else
            return false;
    }

    public boolean coordRider(Coord loc) {
        if (loc.row < 0 || loc.row > (this.row - 1) || loc.col < 0 || loc.col > (this.col - 1))
            return false;
        else
            return rider != null && (loc.equals(rider.location));
    }

    public void update() {
        toDrive();
    }


    public String toString() {

        String s = "=";
        for (int i = 0; i < col - 1; i++) {
            s += "=";
        }
        s += "\n";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                s += Grid[i][j] == null ? " " : Grid[i][j].getSymbol();
            }
            s += "\n";
        }

        for (int i = 0; i < col; i++) {
            s += "=";
        }
        return s;
    }
}

