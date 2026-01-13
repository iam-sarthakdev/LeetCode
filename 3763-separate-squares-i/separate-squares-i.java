class Solution {

    public double separateSquares(int[][] squares) {

        // Step 1: Find search space and total area
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double len = sq[2];

            low = Math.min(low, y);
            high = Math.max(high, y + len);

            totalArea += len * len;
        }

        double target = totalArea / 2.0;

        // Step 2: Binary search on Y
        for (int iter = 0; iter < 100; iter++) { // enough for 1e-5 precision
            double mid = (low + high) / 2.0;

            if (areaBelow(mid, squares) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Calculates area strictly below horizontal line yLine
    private double areaBelow(double yLine, int[][] squares) {
        double area = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double len = sq[2];

            if (yLine <= y) {
                // no contribution
                continue;
            } else if (yLine >= y + len) {
                // whole square below
                area += len * len;
            } else {
                // partially below
                area += (yLine - y) * len;
            }
        }

        return area;
    }
}
