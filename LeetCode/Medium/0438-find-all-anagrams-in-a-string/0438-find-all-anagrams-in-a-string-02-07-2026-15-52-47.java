class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int freq[] = new int[26];
        int winFreq[] = new int[26];

        for(char c : p.toCharArray()){
            freq[c - 'a']++;
        }

        int i = 0, j = 0;

        while(j < s.length()){
            char ch  = s.charAt(j);
            winFreq[ch - 'a']++;

            if(j - i + 1 > p.length()){
                char left = s.charAt(i);
                winFreq[left - 'a']--;
                i++;
            }
            if(j - i + 1 == p.length()){
                if(matches(freq, winFreq)){
                    res.add(i);
                }
            }
            j++;
        }
        return res;
    }
    private boolean matches(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i])return false;
        }
        return true;
    }
}