class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int seats = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') seats++;
        }
        if (seats == 0 || seats % 2 == 1) return 0;

        long ways = 1;
        int seenSeats = 0;
        int plants = 0;

        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                seenSeats++;
                if (seenSeats > 2 && seenSeats % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else {
                if (seenSeats % 2 == 0 && seenSeats > 0) plants++;
            }
        }
        return (int) ways;
    }
}