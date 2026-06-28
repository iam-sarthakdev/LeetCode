class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0; 
        double max = Integer.MIN_VALUE, winSum = 0;

        while(j < nums.length){
            winSum += nums[j];

            if(j - i + 1 < k) j++;

            else if(j - i +1 == k){
                double average = winSum / k;
                max = Math.max(average, max);

                winSum -= nums[i];
                i++;
                j++;

            }
        }
        return max;
    }
}