package alpacamida;

public class EastWestController extends CarController {
    public EastWestController(CoordInfo oracle) {
        super(oracle);
    }

    /**
     *
     */
    @Override
    public void setDefaultDirection() {
        if (direction == NORTH || direction == SOUTH || direction == ORIGIN) {
            direction = EAST;
        }
    }

    ;

    // return the direction when roaming 
    @Override
    public Coord roam(Coord current) {
        if (!oracle.coordFree(current.add(direction))) {
            if (direction == EAST) {
                direction = WEST;
            } else {
                direction = EAST;
            }
        }
        return direction;
    }

    // return the direction when driving 

    /**
     * @param current
     * @param goal
     * @return
     */
    @Override
    public Coord drive(Coord current, Coord goal) {
        Coord diff = current.diff(goal);
        if (diff.col > 0) {
            if (oracle.coordFree(current.add(EAST))) {
                return EAST;
            } else if (diff.row >= 0) {
                return NORTH;
            } else
                return SOUTH;
        } else if (diff.col < 0) {
            if (oracle.coordFree(current.add(WEST))) {
                return WEST;
            } else if (diff.row >= 0) {
                return NORTH;
            } else
                return SOUTH;
        } else {
            if (diff.row > 0) {
                if (oracle.coordFree(current.add(NORTH)))
                    return NORTH;
                else
                    return EAST;
            } else if (diff.row < 0) {
                if (oracle.coordFree(current.add(SOUTH)))
                    return SOUTH;
                else
                    return EAST;
            } else
                return ORIGIN;
        }
    }

}
