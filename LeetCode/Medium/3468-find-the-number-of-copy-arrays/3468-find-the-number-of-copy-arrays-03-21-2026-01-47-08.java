class Solution {
    public int countArrays(int[] original, int[][] bounds) {
    int low = bounds[0][0], high = bounds[0][1], ans = high - low + 1;
    for(int i = 1; i < original.length; ++i){
        int diff = original[i] - original[i-1];
        low = Math.max(low + diff, bounds[i][0]);
        high = Math.min(high + diff, bounds[i][1]);
        ans = Math.min(ans, high - low + 1);
    }
    return ans < 0?0: ans;
}
}