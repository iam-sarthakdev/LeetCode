class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            totalCost += cost[i];
            totalGas += gas[i];
            tank += gas[i] - cost[i];

            if(tank < 0){ // this is invalid start
            start = i+1;
            tank = 0;
            }
        }

        if(totalCost > totalGas) return -1;
        return start;
    }
}