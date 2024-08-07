import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final short x;
    private final short y;
    public Point(short x, short y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Point that) {

    }

    public void drawTo(Point that) {

    }
    public String toString(){
        return "";
    }

    public int compareTo(Point that) {
        if(this.y < that.y)
        {
            return -1;
        } else if (this.y == that.y) {
            return 0;
        } else {
            return 1;
        }
    }
    public double slopeTo(Point that) {
        if(this.y == that.y && this.x == that.x) {
            return -1 / 0.0;
        } else if(this.x == that.x) {
            return 1 / 0.0;
        }
        else if(this.y == that.y) {
            return 0;
        } else {
            return (double)(that.y - this.y) / (that.x - this.x);
        }
    }
    public Comparator<Point> slopeOrder() {

    }

    public static void main(String[] args) {

    }
}
