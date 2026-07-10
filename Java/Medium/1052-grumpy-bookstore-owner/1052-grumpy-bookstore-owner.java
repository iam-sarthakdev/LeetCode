class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int baseSatisfy = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                baseSatisfy += customers[i];
            }
        }
            int left = 0;
            int extraSatisfy = 0;
            int maxExtraSatisfy = 0;
            int right = 0;
            while(right < customers.length){
                if(grumpy[right] == 1){
                    extraSatisfy += customers[right];
                }
                if(right - left + 1 > minutes){
                    if(grumpy[left] == 1){
                         extraSatisfy -= customers[left];
                    }
                    left++;
                }
                maxExtraSatisfy = Math.max(maxExtraSatisfy, extraSatisfy);
                right++;
            }
            return maxExtraSatisfy + baseSatisfy;
    }
}
