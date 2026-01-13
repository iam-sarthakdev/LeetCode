class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0,1);

        for(int x : nums){
            prefixSum += x;

            int rem = prefixSum % k;
            rem = (rem + k) % k;
            
            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}