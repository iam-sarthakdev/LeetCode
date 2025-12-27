class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;

        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= start && intervals[i][1] <= end){
                count++;
            }else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return n - count;
    }
}