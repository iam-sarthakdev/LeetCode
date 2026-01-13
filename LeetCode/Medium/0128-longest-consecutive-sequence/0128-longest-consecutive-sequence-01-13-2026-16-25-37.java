class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxStreak = 0;

        if(nums.length == 0) return 0;

        for(int x : nums){
            set.add(x);
        }

        for(int num : set){

            if(!set.contains(num - 1)){
                int currNum = num;
                int currStreak = 1;

                while(set.contains(currNum + 1)){
                    currNum++;
                    currStreak++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }
}