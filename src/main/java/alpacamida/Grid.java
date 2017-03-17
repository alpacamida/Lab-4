package alpacamida;

import java.util.ArrayList;

public class Grid implements GridInfo, CoordInfo {
    private int row;
    private int col;
    private GridObject Grid[][];
    private Rider rider;
    private ArrayList<Rider> RiderArr = new ArrayList<Rider>();
    private ArrayList<SharedCar> CarArr = new ArrayList<SharedCar>();
    private ArrayList<Obstacle> ObstacleArr = new ArrayList<Obstacle>();

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;
        Grid = new GridObject[row][col];
    }

    public boolean addRider(Rider a, Coord x) {
        if (coordFree(x)) {
            RiderArr.add(a);
            rider = a;
            Grid[x.row][x.col] = a;
            toDrive();
            return true;
        } else
            return false;
    }

    public boolean addCar(SharedCar a, Coord x) {
        if (coordFree(x)) {
            CarArr.add(a);
            Grid[x.row][x.col] = a;
            return true;
        } else return false;
    }

    public boolean addObstacle(Obstacle a, Coord x) {
        if (coordFree(x)) {
            ObstacleArr.add(a);
            Grid[x.row][x.col] = a;
            return true;
        } else return false;
    }

    public boolean toDrive() {
        for (int i = 0; i < CarArr.size(); i++) {
            CarArr.get(i).newRider(rider.location);
        }

        for (int i = 0; i < CarArr.size(); i++) {
            CarArr.get(i).drive();

        }
        return true;
    }

    public boolean riderLoaded(SharedCar car) {

        if (rider.location == car.location) {
            RiderArr.get(RiderArr.size() - 1).pickUp(car);
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
            return (loc == rider.location);
    }


    public java.lang.String toString() {
        System.out.print("test2");
        String str[][] = new String[row][col];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                if (Grid[i][j] == null) {
                    str[i][j] = " ";
                } else {
                    for (int k = 0; k < RiderArr.size(); k++) {

                        if (RiderArr.get(k).getLocation() == Grid[i][j].getLocation()) {
                            str[i][j] = "R";
                            break;
                        }
                    }
                    for (int k = 0; k < CarArr.size(); k++) {
                        if (CarArr.get(k).getLocation() == Grid[i][j].getLocation()) {
                            str[i][j] = "C";
                            break;
                        }
                    }
                    for (int k = 0; k < ObstacleArr.size(); k++) {
                        if (ObstacleArr.get(k).getLocation() == Grid[i][j].getLocation()) {
                            str[i][j] = "#";
                            break;
                        }
                    }
                }
            }
        }
        System.out.print("test3");

        String s = "=";
        for (int i = 0; i < col - 1; i++) {
            s += "=";
        }
        s += "\n";

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                s += str[i][j];
            }
            s += "\n";
        }

        for (int i = 0; i < col; i++) {
            s += "=";
        }
        return s;
    }
}

