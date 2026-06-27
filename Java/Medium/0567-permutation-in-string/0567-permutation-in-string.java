class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] winFreq = new int[26];

        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }
        int i = 0, j = 0;

        while(j < s2.length()){
            char ch = s2.charAt(j);
            winFreq[ch - 'a']++;

            // window invalid
            if(j - i + 1 > s1.length()){
                char left = s2.charAt(i);
                winFreq[left - 'a']--;
                i++;
            }

            // valid window
            if(j - i + 1 == s1.length()){
                if(matches(freq, winFreq)) return true;
            }
            j++;
        }
        return false;
    }
    private boolean matches(int[] a, int[] b){
        for(int i= 0; i < a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}