package euclin.std;

public class IntPoint {

    public int x;
    public int y;

    public IntPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Toutes ces opérations sont des opérations membres-à-membres
    public IntPoint add(IntPoint other) {
        return new IntPoint(x+other.x, y+other.y);
    }

    public IntPoint sub(IntPoint other) {
        return new IntPoint(x-other.x, y-other.y);
    }

    public IntPoint times(IntPoint other) {
        return new IntPoint(x*other.x, y*other.y);
    }

    public IntPoint div(IntPoint other) {
        return new IntPoint(x/other.x, y/other.y);
    }
}
