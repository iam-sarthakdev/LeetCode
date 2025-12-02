class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();

        for(int num : nums2){
            while(!st.isEmpty() && num > st.peek()){
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}