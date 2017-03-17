/**
 * Created by s.m1 on 3/16/2017.
 */
public class Simulation implements Runnable
{
    private int row;
    private int col;
    private int tickMS=10;

    public Simulation(row,col) {
        this.row = row;
        this.col = col;
    }
    Grid grid = new Grid (row,col);
    Simulation simulation = new Simulation(row,col);
    GridSetup gridsetup = new GridSetup ("GridTest1");
    TimeTick timetick = new TimeTick (tickMS,grid,simulation);  //Calling simulation itself as recursion?
    Thread thread = new Thread(timetick); //Is thread and timetick the same thing?

    public boolean update(Grid grid, GraphicsGrid graphic)
    {

    }
    //GUI

    if (tickMS == 100)
    {
        thread.run();
    }

    thread.interrupt();
}
