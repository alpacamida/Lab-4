import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManualController extends CarController implements KeyListener {
    public ManualController(CoordInfo oracle) {
        super(oracle);
    }
    SharedCar userCar;
    Coord currentDirection = new Coord (NORTH);
    int[] turns = new int[4];
    turns[0] = 0;
    turn

    @Override
    public void setDefaultDirection() {
        if (direction == EAST || direction == WEST || direction == ORIGIN) {
            direction = NORTH;
        }
    }

    @Override
    public Coord roam(Coord current) {
        return ORIGIN;
    }

    @Override
    public Coord drive(Coord current, Coord goal) {
        Coord newCoord = current.add(direction);
        if (oracle.coordFree(newCoord)  || oracle.coordRider(newCoord)) {
            return currentDirection;
        }
        else {
            return ORIGIN;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='h'){
        //matrix
        }
        if (e.getKeyChar() == 'l'){
            //matrix
        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE){
            userCar.drive();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
