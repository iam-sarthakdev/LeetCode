class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] prefixY = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixY[i + 1] = prefixY[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int totalY = prefixY[n];
        int bestHour = 0;
        int minPenalty = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            int noCustomerOpen = j - prefixY[j];
            int customerClosed = totalY - prefixY[j];
            int penalty = noCustomerOpen + customerClosed;

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
    }
}
