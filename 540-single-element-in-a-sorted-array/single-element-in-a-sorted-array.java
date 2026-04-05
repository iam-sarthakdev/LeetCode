class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int x : nums){
            xor ^= x;
        }
        return xor;
    }
}