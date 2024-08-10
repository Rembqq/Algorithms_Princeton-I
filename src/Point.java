import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final short x;
    private final short y;
    public Point(short x, short y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Point that) {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
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
            return Double.NEGATIVE_INFINITY;
        } else if(this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        else if(this.y == that.y) {
            return +0.0;
        } else {
            return (double)(that.y - this.y) / (that.x - this.x);
        }
    }
    public Comparator<Point> slopeOrder() {
        return new SlopeOrderComparator();
    }

    private class SlopeOrderComparator implements Comparator<Point>{
        public int compare(Point p1, Point p2) {
            double slope1 = slopeTo(p1);
            double slope2 = slopeTo(p2);
            return Double.compare(slope1, slope2);
        }
    }
}
