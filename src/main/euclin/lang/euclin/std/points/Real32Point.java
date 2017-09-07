package euclin.std.points;

public class Real32Point {

    public float x;
    public float y;

    public Real32Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Real32Point plus(Real32Point other) {
        return new Real32Point(x+other.x, y+other.y);
    }

    public Real32Point minus(Real32Point other) {
        return new Real32Point(x-other.x, y-other.y);
    }

    public Real32Point times(Real32Point other) {
        return new Real32Point(x*other.x, y*other.y);
    }

    public Real32Point div(Real32Point other) {
        return new Real32Point(x/other.x, y/other.y);
    }

    public Real32Point set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
}