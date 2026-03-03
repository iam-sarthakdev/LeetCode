class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            int rightVal = ((mid + 1) < n) ? nums[mid+1] : Integer.MIN_VALUE;
            int leftVal = ((mid - 1) >= 0) ? nums[mid-1] : Integer.MIN_VALUE;

            if(nums[mid] > rightVal && nums[mid] > leftVal) return mid;
            else if(nums[mid] < rightVal) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}