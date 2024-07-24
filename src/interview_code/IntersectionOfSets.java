package interview_code;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;

public class IntersectionOfSets {
//    static class Point {
//        int x, y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) {
//                return true;
//            }
//            if (obj == null || getClass() != obj.getClass()) {
//                return false;
//            }
//            Point point = (Point) obj;
//            return point.x == x && point.y == y;
//        }
//
//        public int hashCode() {
//            return 31 * x + y;
//        }
//    }
    public static int countIntersection(Point2D[] a, Point2D[] b) {
        HashSet<Point2D> set = new HashSet<>();
        for(Point2D p : a) {
            set.add(p);
        }
        // set.setAll(Arrays.asList(a));

        int count = 0;
        for(Point2D p : b) {
            if(set.contains(p)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Пример использования метода
        int n = 1000; // Количество точек
        Point2D[] a = new Point2D[n];
        Point2D[] b = new Point2D[n];

        // Заполняем массивы случайными точками
        for (int i = 0; i < n; i++) {
            a[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            b[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        }

        // Считаем количество пересечений
        int intersectionCount = countIntersection(a, b);
        System.out.println("Number of intersecting points: " + intersectionCount);
    }
}
