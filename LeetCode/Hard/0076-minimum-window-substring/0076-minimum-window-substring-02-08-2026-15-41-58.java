class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int required = t.length();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                if(map.get(ch) > 0) required--;
                map.put(ch, map.get(ch)-1);
            }

            while(required == 0){
                if((right - left + 1) < minLen){
                    start = left;
                    minLen = right - left + 1;
                }
                char chLeft = s.charAt(left);
                if(map.containsKey(chLeft)){
                    if(map.get(chLeft) >= 0) required++;
                    map.put(chLeft, map.get(chLeft)+1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}