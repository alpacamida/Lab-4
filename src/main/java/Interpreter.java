import java.util.Scanner;

public class Interpreter {
    private void printHelpMessage() {
        System.out.println("Give one of the following commands");
        System.out.println("- d -> drive");
        System.out.println("- c <row> <col> -> add a car");
        System.out.println("- r <row> <col> -> add a rider");
        System.out.println("- o <row> <col> -> add an obstacle");
        System.out.println("- q -> quit simulation");
    }

    public void startAcceptingUserInput(Simulation simulation) {
        printHelpMessage();
        System.out.println(simulation.grid.toString());
        Scanner scnr = new Scanner(System.in);
        CarController controller = new EastWestController(simulation.grid);

        while (scnr.hasNextLine()) {
            String[] command = scnr.nextLine().split(" ");
            if (command[0].equals("q")) {
                simulation.stopSimulation();
                break;
            }
            if (command[0].equals("d")) {
                simulation.grid.toDrive();
            } else {
                Coord newCoord;
                try {
                    int row = Integer.parseInt(command[1]);
                    int col = Integer.parseInt(command[2]);
                    newCoord = new Coord(row, col);
                } catch (NumberFormatException e) {
                    printHelpMessage();
                    continue;
                } catch (ArrayIndexOutOfBoundsException e) {
                    printHelpMessage();
                    continue;
                }
                boolean addObjectResult;
                switch (command[0]) {
                    case "c":
                        addObjectResult = simulation.grid.addCar(new SharedCar(controller, simulation.grid), newCoord);
                        break;
                    case "r":
                        addObjectResult = simulation.grid.addRider(new Rider(), newCoord);
                        break;
                    case "o":
                        addObjectResult = simulation.grid.addObstacle(new Obstacle(), newCoord);
                        break;
                    default:
                        printHelpMessage();
                        continue;
                }
                if (!addObjectResult) {
                    System.out.println("Coord " + newCoord.toString() + " has been occupied already");
                }
            }
            System.out.println(simulation.grid.toString());
        }

    }
}
