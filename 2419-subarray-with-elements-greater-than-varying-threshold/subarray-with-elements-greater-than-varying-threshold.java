class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n=nums.length;
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || nums[i]<nums[stack.peek()])){
                int num = nums[stack.pop()];
                int len = stack.isEmpty() ? i : i-stack.peek()-1;
                if(num > threshold/len) return len;
            }
            stack.push(i);
        }
        return -1;
    }
}