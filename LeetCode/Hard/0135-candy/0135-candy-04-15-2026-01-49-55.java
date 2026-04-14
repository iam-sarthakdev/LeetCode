class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = 1 + candy[i-1];
            }
        }
        for(int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i+1] + 1, candy[i]);
            }
        }
        int total = 0;
        for(int num : candy) total += num;
        return total;
    }
}