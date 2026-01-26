class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); // Step 1: sort
        
        int minDiff = Integer.MAX_VALUE;

        // Step 2: find minimum difference between adjacent elements
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        // Step 3: collect all pairs with minDiff
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }
}
