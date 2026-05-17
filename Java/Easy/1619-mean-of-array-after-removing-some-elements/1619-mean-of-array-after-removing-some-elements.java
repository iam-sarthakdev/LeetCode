class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        int offset = 5 * n / 100;
        int start = offset;
        int end = n - offset;
        double total = end - start;
        double sum = 0;
        Arrays.sort(arr);
        for (int i = start; i < end; i++)
            sum += arr[i];
        return sum / total;
    }
}