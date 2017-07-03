package euclin.std.points;

public class Int64Point {

    public long x;
    public long y;

    public Int64Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    // Toutes ces opérations sont des opérations membres-à-membres
    public Int64Point plus(Int64Point other) {
        return new Int64Point(x+other.x, y+other.y);
    }

    public Int64Point minus(Int64Point other) {
        return new Int64Point(x-other.x, y-other.y);
    }

    public Int64Point times(Int64Point other) {
        return new Int64Point(x*other.x, y*other.y);
    }

    public Int64Point div(Int64Point other) {
        return new Int64Point(x/other.x, y/other.y);
    }

    public Int64Point set(long x, long y) {
        this.x = x;
        this.y = y;
        return this;
    }
}