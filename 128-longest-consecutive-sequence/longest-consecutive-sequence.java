class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        if(nums.length == 0) return 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num - 1)){ // start of sequence
            int count = 1;
            int number = num;

            while(set.contains(number + 1)){
                count++;
                number++;   
            }
            maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}