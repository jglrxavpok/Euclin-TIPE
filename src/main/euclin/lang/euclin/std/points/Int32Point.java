package euclin.std.points;

public class Int32Point {

    public int x;
    public int y;

    public Int32Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Toutes ces opérations sont des opérations membres-à-membres
    public Int32Point plus(Int32Point other) {
        return new Int32Point(x+other.x, y+other.y);
    }

    public Int32Point minus(Int32Point other) {
        return new Int32Point(x-other.x, y-other.y);
    }

    public Int32Point times(Int32Point other) {
        return new Int32Point(x*other.x, y*other.y);
    }

    public Int32Point div(Int32Point other) {
        return new Int32Point(x/other.x, y/other.y);
    }

    public Int32Point set(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
}