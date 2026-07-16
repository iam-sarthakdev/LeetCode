public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        // index of the previous 1 seen
        int prevIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prevIndex != -1) {
                    // number of zeros between prevIndex and current = (i - prevIndex - 1)
                    if (i - prevIndex - 1 < k) {
                        return false;
                    }
                }
                prevIndex = i;
            }
        }
        
        return true;
    }
}
