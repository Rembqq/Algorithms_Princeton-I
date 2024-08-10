public class BruteCollinearPoints {
    public BruteCollinearPoints(Point[] points) {

        // corner cases
        if(points == null)
        {
            throw new IllegalArgumentException();
        }
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException();
            }
        }
        for(int i = 0; i < points.length - 1; ++i) {
            for(int j = i + 1; j < points.length; ++j) {
                if(points[i] == points[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    public int numberOfSegments() {

    }
    public LineSegment[] segments() {

    }
}
