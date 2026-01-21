class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            if (num == 2) {
                ans[i] = -1;
                continue;
            }

            int bit = 0;
            while ((num & (1 << bit)) != 0) {
                bit++;
            }

            // flip the highest bit of trailing 1s
            ans[i] = num ^ (1 << (bit - 1));
        }

        return ans;
    }
}
