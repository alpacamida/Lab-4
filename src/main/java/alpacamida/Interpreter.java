package alpacamida;

import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    public static void main(String[] args) {
        Grid grid = new Grid(row, col);
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        GridSetup gridsetup = new GridSetup("gridtest1.txt");
        int row = gridsetup.getDimension().row;
        int col = gridsetup.getDimension().col;
        Grid grid = new Grid(row, col);
        EastWestController east = new EastWestController(grid);


        while (scnr.next() != null) {
            input.add() = scnr.next();
        }
        for (int i = 0; i < input.size(); ++i) {
            if (input.get(i).equals("Drive")) {

                System.out.println(grid.toString());
            } else if (input.get(i).equals("Car")) {
                int rowone = scnr.nextInt();
                int colone = scnr.nextInt();
                Coord x = new Coord(rowone, colone);
                SharedCar car = new SharedCar(east, grid);
                grid.addCar(car, x);
                System.out.println(grid.toString());
            } else if (input.get(i).equals("alpacamida.Rider")) {
                int rowtwo = scnr.nextInt();
                int coltwo = scnr.nextInt();
                Coord y = new Coord(rowtwo, coltwo);
                Rider rider = new Rider();
                grid.addCAr(rider, y);
                System.out.println(grid.toString());
            } else if (input.get(i).equals("alpacamida.Obstacle")) {
                int rowthree = scnr.nextInt();
                int colthree = scnr.nextInt();
                Coord z = new Coord(rowthree, colthree);
                Obstacle obstacle = new Obstacle();
                grid.addObstacle(obstacle, z);
                System.out.println(grid.toString());
            }
        }

    }
}
