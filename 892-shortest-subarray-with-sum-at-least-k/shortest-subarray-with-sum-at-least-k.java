class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefix = new long[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i <= nums.length; i++){

            while(!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k){
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}