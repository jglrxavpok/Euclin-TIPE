package euclin.std;

public class RealPoint {

    public float x;
    public float y;

    public RealPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public RealPoint add(RealPoint other) {
        return new RealPoint(x+other.x, y+other.y);
    }

    public RealPoint sub(RealPoint other) {
        return new RealPoint(x-other.x, y-other.y);
    }

    public RealPoint times(RealPoint other) {
        return new RealPoint(x*other.x, y*other.y);
    }

    public RealPoint div(RealPoint other) {
        return new RealPoint(x/other.x, y/other.y);
    }

    public RealPoint set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
}
