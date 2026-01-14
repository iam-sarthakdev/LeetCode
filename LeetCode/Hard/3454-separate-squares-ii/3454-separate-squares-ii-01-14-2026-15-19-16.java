class Solution {
    public double separateSquares(int[][] squares) {
        // Collect all unique y-coordinates
        TreeSet<Integer> ySet = new TreeSet<>();
        for (int[] sq : squares) {
            int y = sq[1], L = sq[2];
            ySet.add(y);
            ySet.add(y + L);
        }
        
        List<Integer> yCoords = new ArrayList<>(ySet);
        
        // Build segments: for each y-strip, calculate the covered width
        List<Segment> segments = new ArrayList<>();
        
        for (int i = 0; i < yCoords.size() - 1; i++) {
            int y1 = yCoords.get(i);
            int y2 = yCoords.get(i + 1);
            
            // Find all squares that cover this y-range [y1, y2]
            List<int[]> intervals = new ArrayList<>();
            for (int[] sq : squares) {
                int x = sq[0], y = sq[1], L = sq[2];
                // Square covers y-range [y, y+L]
                if (y <= y1 && y2 <= y + L) {
                    // This square covers the strip [y1, y2]
                    intervals.add(new int[]{x, x + L});
                }
            }
            
            // Merge overlapping intervals to get total width
            double width = getTotalWidth(intervals);
            double height = y2 - y1;
            double area = width * height;
            
            segments.add(new Segment(y1, y2, area));
        }
        
        // Calculate total area
        double totalArea = 0;
        for (Segment seg : segments) {
            totalArea += seg.area;
        }
        
        double targetArea = totalArea / 2.0;
        
        // Find the y-coordinate where cumulative area = targetArea
        double cumulativeArea = 0;
        for (Segment seg : segments) {
            if (cumulativeArea + seg.area >= targetArea) {
                // The answer is within this segment
                if (seg.area == 0) {
                    return seg.y1;
                }
                double remaining = targetArea - cumulativeArea;
                double fraction = remaining / seg.area;
                return seg.y1 + fraction * (seg.y2 - seg.y1);
            }
            cumulativeArea += seg.area;
        }
        
        return yCoords.get(yCoords.size() - 1);
    }
    
    private double getTotalWidth(List<int[]> intervals) {
        if (intervals.isEmpty()) return 0;
        
        // Sort by start position
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        double totalWidth = 0;
        int currentStart = intervals.get(0)[0];
        int currentEnd = intervals.get(0)[1];
        
        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            
            if (start <= currentEnd) {
                // Overlapping or adjacent - merge
                currentEnd = Math.max(currentEnd, end);
            } else {
                // Gap - add current interval and start new one
                totalWidth += currentEnd - currentStart;
                currentStart = start;
                currentEnd = end;
            }
        }
        
        // Add the last interval
        totalWidth += currentEnd - currentStart;
        
        return totalWidth;
    }
    
    static class Segment {
        int y1, y2;
        double area;
        
        Segment(int y1, int y2, double area) {
            this.y1 = y1;
            this.y2 = y2;
            this.area = area;
        }
    }
}