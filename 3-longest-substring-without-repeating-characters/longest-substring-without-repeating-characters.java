class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){

            Character ch = s.charAt(right);
            if(lastSeen.containsKey(ch) && lastSeen.get(ch) >= left){
                left = lastSeen.get(ch)+1;
            }
                lastSeen.put(ch, right);

                maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }
}