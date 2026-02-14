class Solution {
    public int longestSubstring(String s, int k) {
        
        int maxLen = 0;
        
        // Try for every possible unique character count (1 to 26)
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            
            int[] freq = new int[26];   // Frequency array
            int left = 0;
            int right = 0;
            
            int uniqueCount = 0;        // How many unique characters in window
            int countAtLeastK = 0;      // How many characters have freq >= k
            
            while (right < s.length()) {
                
                // Expand window (move right)
                int index = s.charAt(right) - 'a';
                
                if (freq[index] == 0) {
                    uniqueCount++;   // New unique character found
                }
                
                freq[index]++;
                
                if (freq[index] == k) {
                    countAtLeastK++;  // This character now satisfies k condition
                }
                
                right++;
                
                // Shrink window if unique characters exceed target
                while (uniqueCount > targetUnique) {
                    
                    int leftIndex = s.charAt(left) - 'a';
                    
                    if (freq[leftIndex] == k) {
                        countAtLeastK--;  // This character no longer satisfies k
                    }
                    
                    freq[leftIndex]--;
                    
                    if (freq[leftIndex] == 0) {
                        uniqueCount--;  // One unique character removed
                    }
                    
                    left++;
                }
                
                // Check if valid substring
                if (uniqueCount == targetUnique && uniqueCount == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        
        return maxLen;
    }
}
