class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        Map<Character,Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int needed = t.length();
        int start = 0;
        int i = 0, j= 0;

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0) needed--;
                map.put(ch, map.get(ch)-1);
            }

            while(needed == 0){
                int winLen = j - i + 1;
                if(winLen < minLen){
                minLen = winLen;
                start = i;
                }

                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left, map.get(left)+1);
                    if(map.get(left) > 0) needed++;
                }
                i++;
            }
            j++;
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}