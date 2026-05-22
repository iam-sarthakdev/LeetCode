class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = find(slow);
            fast = find(find(fast));
            // if(fast == 1) return true;
        }while(slow != fast);
        return slow == 1;
        
    }
    private int find(int n){
        int res = 0;
        while(n != 0){
            int digit = n % 10;
            n /= 10;
            res += digit * digit;
        }
        return res;
    }
}