import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int maxPoints = 2;
        
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeCount = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double slope = calculateSlope(points[i], points[j]);
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                    maxPoints = Math.max(maxPoints, slopeCount.get(slope));
                }
            }
        }
        
        return maxPoints;
    }
    
    private double calculateSlope(int[] point1, int[] point2) {
        int x1 = point1[0], y1 = point1[1];
        int x2 = point2[0], y2 = point2[1];
        
        if (x1 == x2) return Double.POSITIVE_INFINITY;
        if (y1 == y2) return 0;
        
        return (double)(y2 - y1) / (x2 - x1);
    }
}
