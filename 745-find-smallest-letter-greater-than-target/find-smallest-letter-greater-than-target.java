class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (letters[mid] <= target) {
                // Need strictly greater, so move right
                low = mid + 1;
            } else {
                // Possible answer, try to find smaller index
                high = mid - 1;
            }
        }
        
        // low can be n, so use modulo for circular behavior
        return letters[low % n];
    }
}
