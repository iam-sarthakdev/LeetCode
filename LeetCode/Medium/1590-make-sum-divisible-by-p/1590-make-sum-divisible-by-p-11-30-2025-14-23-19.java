class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int n : nums) total += n;

        int rem = (int)(total % p);
        if (rem == 0) return 0; // already divisible

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix sum before starting

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            // current prefix mod p
            prefix = (prefix + nums[i]) % p;

            // we want prefix[i] mod p = (prefix - rem + p) % p
            int need = (int)((prefix - rem + p) % p);

            // if previous prefix with this remainder exists → valid subarray
            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            // store/update current prefix remainder
            map.put((int)prefix, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
