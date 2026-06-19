class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;
        for(int n : gain){
            altitude += n;
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }
}