import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {
    private LineSegment[] segments = null;
    public FastCollinearPoints(Point[] points) {

        if(points == null) {
            throw new IllegalArgumentException();
        }

        Point[] pointsCopy = new Point[points.length];

        for (int i = 0; i < pointsCopy.length; ++i) {
            if(points[i] == null) {
                throw new IllegalArgumentException();
            }
            pointsCopy[i] = points[i];
        }

        // creates dynamic array for adding elems
        // which then are copied with .toArray method
        Arrays.sort(pointsCopy);
        List<LineSegment> lineSegments = new LinkedList<>();

        Point previousPoint = null;

        for (int i = 0; i < pointsCopy.length; ++i) {
            Point p = pointsCopy[i];

            if (previousPoint != null && p.compareTo(previousPoint) == 0) {
                throw new IllegalArgumentException();
            } else {
                previousPoint = p;
            }

            // creates array sorted by its slope
            // and sorts it for fast analysis of elems
            Point[] slopeOrderedPoints = pointsCopy.clone();
            Arrays.sort(slopeOrderedPoints, p.slopeOrder());

            int slopeStartIndex = 0;
            double lastSlope = Double.NEGATIVE_INFINITY;

            // no need to write if(i == j) { continue; } as Arrays.sort always
            // carries our point on first place

            for (int j = 1; j < pointsCopy.length; ++j) {
                Point q  = slopeOrderedPoints[j];
                boolean lastPoint = j == slopeOrderedPoints.length - 1;
                double currentSlope = p.slopeTo(q);
                if(Double.compare(currentSlope, lastSlope) != 0) {
                    // at least four points (3j and 1i)
                    if(j - slopeStartIndex >= 3) {
                        // this says true if first adjacent elem from our p(origin)
                        // is located in first or second quarter of trigonometric circle
                        // considering p is in centre(basically if p is below sSIndex)
                        if(p.compareTo(slopeOrderedPoints[slopeStartIndex]) <= 0) {
                            // j - 1 because (our current elem != previousElem) ==> we have
                            // to take last suitable
                            LineSegment segment = new LineSegment(p, slopeOrderedPoints[j - 1]);
                            lineSegments.add(segment);
                        }
                    }
                    slopeStartIndex = j;
                } else if(lastPoint) {
                    if(j - slopeStartIndex >= 2) {
                        if(p.compareTo(slopeOrderedPoints[slopeStartIndex]) <= 0) {
                            LineSegment segment = new LineSegment(p, q);
                            lineSegments.add(segment);
                        }
                    }
                }
                lastSlope = currentSlope;
            }
        }
        // segments = lineSegments.toArray(new LineSegment[0]) is the same, just takes
        // a bit longer due to creating new inner array to find out true array size
        segments = lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
    public int numberOfSegments() {
        return segments.length;
    }
    public LineSegment[] segments() {
        return segments;
    }
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
