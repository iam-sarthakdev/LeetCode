class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res ={-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }else{
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
        }
        return res;
    }
}