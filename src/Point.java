import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (this.y == that.y)
        {
            return this.x - that.x;
        } else {
            return this.y - that.y;
        }
    }
    public double slopeTo(Point that) {
        if(this.compareTo(that) == 0) {
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
