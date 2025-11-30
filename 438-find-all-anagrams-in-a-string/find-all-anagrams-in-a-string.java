class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int[] freq = new int[26];
        if(p.length() > s.length()) return list;

        for(char c : p.toCharArray()){
            freq[c - 'a']++;
        }

        int required = p.length();
        int i = 0, j = 0;

        while(j < s.length()){
            char ch = s.charAt(j);

            if(freq[ch - 'a'] > 0){
                required--;
            }
            freq[ch - 'a']--;

            if(j - i + 1 == p.length()){
            if(required == 0) list.add(i);
                char left = s.charAt(i);
                if(freq[left - 'a'] >= 0){
                    required++;
                }
                freq[left - 'a']++;
                i++;
            }
            j++;
        }
        return list;
    }
}