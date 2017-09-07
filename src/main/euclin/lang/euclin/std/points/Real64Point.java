package euclin.std.points;

public class Real64Point {

    public double x;
    public double y;

    public Real64Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Real64Point plus(Real64Point other) {
        return new Real64Point(x+other.x, y+other.y);
    }

    public Real64Point minus(Real64Point other) {
        return new Real64Point(x-other.x, y-other.y);
    }

    public Real64Point times(Real64Point other) {
        return new Real64Point(x*other.x, y*other.y);
    }

    public Real64Point div(Real64Point other) {
        return new Real64Point(x/other.x, y/other.y);
    }

    public Real64Point set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }
}