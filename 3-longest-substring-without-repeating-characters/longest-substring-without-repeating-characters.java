class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int maxLen = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            if(!set.contains(ch)){
                set.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }else{
                char leftCh = s.charAt(left);
                set.remove(leftCh);
                left++;
            }
        }
        return maxLen;
    }
}