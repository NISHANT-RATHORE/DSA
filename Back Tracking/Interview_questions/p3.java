import java.util.Arrays;

public class p3 {
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ClosestPairOfPoints {
    public static double closestPair(Point[] points) {
        // Sort the points by x-coordinate
        Arrays.sort(points, (a, b) -> a.x - b.x);

        // Find the closest pair recursively
        return closestPair(points, 0, points.length - 1);
    }

    private static double closestPair(Point[] points, int left, int right) {
        if (right - left <= 2) {
            // Base case: If there are only 2 or 3 points, calculate the distance directly
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        // Recursively find the closest pair in the left and right halves
        double leftClosest = closestPair(points, left, mid);
        double rightClosest = closestPair(points, mid + 1, right);

        // Find the minimum distance between the left and right halves
        double minDistance = Math.min(leftClosest, rightClosest);

        // Create an array to store the points within the minimum distance from the middle line
        Point[] strip = new Point[right - left + 1];
        int stripSize = 0;

        // Populate the strip array with points within the minimum distance from the middle line
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDistance) {
                strip[stripSize++] = points[i];
            }
        }

        // Sort the points in the strip array by y-coordinate
        Arrays.sort(strip, 0, stripSize, (a, b) -> a.y - b.y);

        // Find the closest pair within the strip
        double stripClosest = stripClosestPair(strip, stripSize, minDistance);

        // Return the minimum distance among the three cases
        return Math.min(minDistance, stripClosest);
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double minDistance = Double.POSITIVE_INFINITY;

        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double distance = calculateDistance(points[i], points[j]);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    private static double stripClosestPair(Point[] strip, int size, double minDistance) {
        double min = minDistance;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; j++) {
                double distance = calculateDistance(strip[i], strip[j]);
                min = Math.min(min, distance);
            }
        }

        return min;
    }

    private static double calculateDistance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Point[] points = { new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1),
                new Point(12, 10), new Point(3, 4) };

        double closestDistance = closestPair(points);
        System.out.println("Closest pair distance: " + closestDistance);
    }
}
}