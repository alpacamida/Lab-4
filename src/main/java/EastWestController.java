import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    final Integer sameDirectionBonus = 10;
    final Integer eastPreference = 4;
    final Integer westPreference = 3;
    final Integer northPreference = 2;
    final Integer southPreference = 1;

    /**
     * @param current
     * @param goal
     * @return
     */
    @Override
    public Coord drive(Coord current, Coord goal) {
        Map<Integer, Coord> weight = new HashMap<>(4);
        Coord diff = current.diff(goal);
        weight.put(diff.col < 0 ? eastPreference + sameDirectionBonus : diff.col > 0 ? eastPreference - sameDirectionBonus : eastPreference, EAST);
        weight.put(diff.col > 0 ? westPreference + sameDirectionBonus : diff.col < 0 ? westPreference - sameDirectionBonus : westPreference, WEST);
        weight.put(diff.row > 0 ? northPreference + sameDirectionBonus : diff.row < 0 ? northPreference - sameDirectionBonus : northPreference, NORTH);
        weight.put(diff.row < 0 ? southPreference + sameDirectionBonus : diff.row > 0 ? southPreference - sameDirectionBonus : southPreference, SOUTH);
        Coord[] preferences = new TreeMap<>(weight).descendingMap().values().toArray(new Coord[4]);
        return navigateFrom(current, preferences);
    }

    private Coord navigateFrom(Coord current, Coord[] preference) {
        for (Coord attempt : preference) {
            if (oracle.coordFree(current.add(attempt))) {
                return attempt;
            }
        }
        // if can't go anywhere
        return ORIGIN;
    }

}
