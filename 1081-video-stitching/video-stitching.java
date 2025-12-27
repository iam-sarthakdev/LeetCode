import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int res = 0;
        int i = 0;
        int n = clips.length;
        int currEnd = 0;
        int farthest = 0;

        while (currEnd < time) {
            while (i < n && clips[i][0] <= currEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }

            if (farthest == currEnd) return -1;

            res++;
            currEnd = farthest;
        }

        return res;
    }
}
