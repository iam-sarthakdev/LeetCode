import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxH = getMaxConsecutive(hBars);
        int maxV = getMaxConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }

    private int getMaxConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        int max = 1;
        int curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
