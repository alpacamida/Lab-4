/**
 * Stage I - The Coord Class
 */
public class Coord implements java.lang.Comparable<Coord> {
    public final int row;
    public final int col;

    private int sign(int a) {
        if (a < 0) return -1;
        else if (a > 0) return 1;
        // FIXME: return 0 when a is 0
        else return 0;
    }


    public Coord() {
        row = 0;
        col = 0;
    }

    public Coord(Coord other) {
        row = other.row;
        col = other.col;
    }

    public Coord(int row1, int col1) {
        row = row1;
        col = col1;
    }

    public Coord dist(Coord b) {
        if (b == null)
            return null;
        int disRow = Math.abs(b.row - row);
        int disCol = Math.abs(b.col - col);
        return new Coord(disRow, disCol);
    }

    public Coord diff(Coord b) {
        if (b == null)
            return null;
        int disRow = row - b.row;
        int disCol = col - b.col;
        return new Coord(disRow, disCol);
    }

    public int dist2(Coord b) {
        if (b == null)
            return Integer.MAX_VALUE;
        int disRow = dist(b).row * dist(b).row;
        int disCol = dist(b).col * dist(b).col;
        return disRow + disCol;
    }

    public Coord unit() {
        return new Coord(sign(row), sign(col));
    }

    public Coord add(Coord b) {
        if (b == null)
            return null;
        int disRow = b.row + row;
        int disCol = b.col + col;
        return new Coord(disRow, disCol);
    }

    public int compareTo(Coord other) {
        if (other == null) {
            return -1;
        }
        if (this.row + this.col > other.row + other.col)
            return 1;
        else if (this.row + this.col == other.row + other.col)
            return 0;
        else
            return -1;
    }

    public boolean equals(java.lang.Object other) {
        if (other instanceof Coord) {
            Coord c = (Coord) other;
            return this.col == c.col && this.row == c.row;
        } else
            return false;
    }

    public java.lang.String toString() {
        return String.format("Coord:(row=%d,col=%d)", row, col);
    }

}
