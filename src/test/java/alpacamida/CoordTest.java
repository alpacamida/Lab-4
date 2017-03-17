package alpacamida;

import junit.framework.TestCase;
/**
 * A Unit Tester for Coord
 *
 * Execute `mvn clean -Dtest=alpacamida.CoordTest test`
 *
 * @author Philip Papadopoulos
 */
public class CoordTest extends TestCase {

    static final int R = 20, C = 43;
    private Coord origin;
    private Coord NEQuad, NWQuad, SEQuad, SWQuad;

    @Override
    /* this sets up the test fixture. JUnit invokes this method before
 	   every testXXX method */
    protected void setUp() throws Exception {
        super.setUp();
        origin = new Coord(0, 0);
        NEQuad = new Coord(R, C);
        SEQuad = new Coord(-R, C);
        NWQuad = new Coord(R, -C);
        SWQuad = new Coord(-R, -C);
    }

    @Override
	/* this tears down the  test fixture. JUnit invokes this method after
 	   every testXXX method */
    protected void tearDown() throws Exception {
        super.tearDown();
        origin = null;
    }

    /**
     * Test the no argument constructor
     */
    public void testNoArgConstructor() {
        System.out.println("Testing no argument Constructor");
        assertEquals(origin.row, 0);
        assertEquals(origin.col, 0);
    }

    /**
     * Test 2-arg Constructor
     */
    public void test2ArgConstructor() {
		/* Test the regular constructor 
		*/
        System.out.println("Testing 2 arg Constructor");
        assertEquals(NWQuad.row, R);
        assertEquals(NWQuad.col, -C);
    }

    /**
     * Test Copy Constructor
     */
    public void testCopyConstructor() {
		/* Test the Copy constructor 
		*/
        System.out.println("Testing Copy Constructor");

        Coord NWCopy = new Coord(NWQuad);
        assertEquals(NWCopy.row, R);
        assertEquals(NWCopy.col, -C);
        assertEquals(NWCopy != NWQuad, true);
    }


    /**
     * Test equals
     */
    public void testEquals() {
        System.out.println("Testing Equals");
		/* Test equals */
        Object foo = new Object();
        Coord NWCopy = new Coord(NWQuad);
        assertEquals(NWCopy.equals(NWQuad), true);
        assertEquals(NWQuad.equals(NWCopy), true);
        assertEquals(NWQuad.equals(NEQuad), false);
        assertEquals(origin.equals(new Coord()), true);
        assertEquals(origin.equals((Coord) null), false);
        assertEquals(origin.equals(foo), false);
    }

    /**
     * Test diff
     */
    public void testDiff() {
		/* Test diff */
        System.out.println("Testing diff");
        assertEquals(NWQuad.diff(origin).equals(NWQuad), true);
        System.out.println(NWQuad.diff(origin));
        assertEquals(NWQuad.diff(NEQuad).equals(new Coord(0, -2 * C)), true);
        assertEquals(SEQuad.diff(NEQuad).equals(new Coord(-2 * R, 0)), true);
        assertEquals(SEQuad.diff(null), null);
    }

    /**
     * Test dist
     */
    public void testDist() {
        System.out.println("Testing dist");
        assertEquals(NWQuad.dist(null), null);
        assertEquals(SEQuad.dist(origin).row, R);
        assertEquals(SEQuad.dist(origin).col, C);
        assertEquals(NWQuad.dist(origin).row, R);
        assertEquals(NWQuad.dist(origin).col, C);
        assertEquals(NWQuad.dist(SEQuad).row, 2 * R);
        assertEquals(NWQuad.dist(SEQuad).col, 2 * C);
    }

    /**
     * Test dist2
     */
    public void testDist2() {
        System.out.println("Testing dist2");
        assertEquals(NWQuad.dist2(null), Integer.MAX_VALUE);
        assertEquals(SEQuad.dist2(origin), R * R + C * C);
        assertEquals(NEQuad.dist2(origin), R * R + C * C);
        assertEquals(NWQuad.dist2(SWQuad), 4 * R * R);
        assertEquals(NWQuad.dist2(NEQuad), 4 * C * C);
        assertEquals(NWQuad.dist2(SEQuad), 4 * (R * R + C * C));
    }

    /**
     * Test unit
     */
    public void testUnit() {
        System.out.println("Testing unit");
        assertEquals(NWQuad.unit().equals(new Coord(1, -1)), true);
        assertEquals(NEQuad.unit().equals(new Coord(1, 1)), true);
        assertEquals(SWQuad.unit().equals(new Coord(-1, -1)), true);
        assertEquals(SEQuad.unit().equals(new Coord(-1, 1)), true);
        assertEquals(origin.unit().equals(new Coord(0, 0)), true);
    }

    /**
     * Test add
     */
    public void testAdd() {
        System.out.println("Testing add");
        assertEquals(NWQuad.add(null), null);
        assertEquals(NWQuad.add(NWQuad).row, 2 * R);
        assertEquals(NWQuad.add(NWQuad).col, -2 * C);
        assertEquals(NWQuad.add(SEQuad).equals(origin), true);
        assertEquals(NEQuad.add(SWQuad).equals(origin), true);
        assertEquals(NEQuad.add(NWQuad).equals(new Coord(2 * R, 0)), true);
    }

    /**
     * Test compareTo
     */
    public void testCompareTo() {
        System.out.println("Testing compareTo");
        assertEquals(NWQuad.compareTo(null) < 0, true);
        // FIXME: Updated test assertion
        assertEquals(NWQuad.compareTo(origin) < 0, true);
        assertEquals(NWQuad.compareTo(SEQuad) < 0, true);
        assertEquals(NWQuad.compareTo(SWQuad) > 0, true);
        assertEquals(NWQuad.compareTo(NEQuad) < 0, true);
        assertEquals(NWQuad.compareTo(NWQuad) == 0, true);
        assertEquals(NWQuad.compareTo(new Coord(R, 0)) < 0, true);
        assertEquals(NWQuad.compareTo(new Coord(-R, 0)) < 0, true);
        assertEquals(NWQuad.compareTo(new Coord(0, C)) < 0, true);
        assertEquals(NWQuad.compareTo(new Coord(0, -C)) > 0, true);
    }
}
//vim: ts=4
