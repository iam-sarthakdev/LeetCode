class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(char ch : t.toCharArray()){
            if(freq[ch - 'a'] == 0) return false;
            freq[ch - 'a']--;
        }
        for(int n : freq){
            if(n > 0) return false;

        }
        return true;
    }
}