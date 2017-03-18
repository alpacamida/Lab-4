public class Simulation {
    private int tickMS = 10;
    public Interpreter input;
    public Thread clockingThread;
    public Grid grid;

    public Simulation(Grid grid) {
        this.grid = grid;
        TimeTick clock = new TimeTick(tickMS, grid, this);
        clockingThread = new Thread(clock);
 //       clockingThread.start();
        input = new Interpreter();
        startSimulation();

    }

    public void startSimulation() {
        input.startAcceptingUserInput(this);
    }

    public void stopSimulation() {
        clockingThread.interrupt();
    }

    public void update() {
        System.out.println(grid.toString());

    }

    /**
     * grid setup file
     *
     * @param args
     */
    public static void main(String[] args) {
        Grid grid;
        if (args.length == 1) {
            // start from a config file
            String fileName = args[0];
            GridSetup setup = new GridSetup(fileName);
            grid = new DummyGrid(setup);
        } else {
            // start from an empty grid with rows and cols
            grid = new Grid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        Simulation simulation = new Simulation(grid);
    }

}
