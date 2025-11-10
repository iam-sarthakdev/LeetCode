public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        // Use Deque as a stack
        Deque<Integer> stack = new ArrayDeque<>();
        // We push a dummy 0 so we don’t need to check empty often
        stack.push(0);
        
        int operations = 0;
        
        for (int num : nums) {
            // As long as the current stack top is > current num,
            // pop it — meaning we collapse larger “value‐levels”
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            // Now: if stack is empty OR stack top is < current num,
            // then we need a new operation for this value
            if (stack.isEmpty() || stack.peek() < num) {
                operations++;
                stack.push(num);
            }
            // else: stack.peek() == num, do nothing (we are extending an existing level)
        }
        
        return operations;
    }
}
