class Solution {
    public long gcd(long a, long b) {
        while(b!=0){
            long temp =b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return a*b / gcd(a,b);
    }

    public long gcdOfArray(int[] arr){
        long res = arr[0];
        for(int i=1; i<arr.length;i++){
            res = gcd(res, arr[i]);
        }
        return res;
    }

    public long lcmOfArray(int[] arr){
        long res = arr[0];
        for(int i=1;i<arr.length;i++){
            res = lcm(res,arr[i]);
        }
        return res;
    }

    public int[] subArray(int[] arr , int index, int n){
        int[] res = new int[n - 1];
        for(int i=0, j=0; i<n; i++){
            if(i==index)continue;
            res[j++]=arr[i];
        }
        return res;
    }

    public long maxScore(int[] nums) {
        int n = nums.length;
        long res = lcmOfArray(nums)*gcdOfArray(nums);
        if(n==1)return res;
        for(int i=0;i<n;i++){
            int[] sub = subArray(nums, i, n);
            res = Math.max(res,lcmOfArray(sub)*gcdOfArray(sub));
        }
        
        return res;
    }
}