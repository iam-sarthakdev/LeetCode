class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        if(s1.length() > s2.length())return false;

        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }
        int i = 0, j = 0, required = s1.length();

        while(j < s2.length()){
            char ch = s2.charAt(j);

            if(freq[ch - 'a'] > 0){
                required--;
            }
            freq[ch - 'a']--;

            if(j - i + 1 == s1.length()){  // valid window
            if(required == 0) return true;

            char left = s2.charAt(i);
            if(freq[left - 'a'] >= 0){
                required++;
            }
            freq[left - 'a']++;
            i++;
            }
            j++;
        }
        return false;
    }
}