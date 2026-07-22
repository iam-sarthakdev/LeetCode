class Solution {
    public int countCollisions(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = 0, j = n - 1;

        // Ignore all leading L (they move out, no collision)
        while (i < n && arr[i] == 'L') i++;

        // Ignore all trailing R (they move out, no collision)
        while (j >= 0 && arr[j] == 'R') j--;

        int collisions = 0;

        // In the middle part: count all non-'S' characters
        for (int k = i; k <= j; k++) {
            if (arr[k] != 'S') collisions++;
        }

        return collisions;
    }
}