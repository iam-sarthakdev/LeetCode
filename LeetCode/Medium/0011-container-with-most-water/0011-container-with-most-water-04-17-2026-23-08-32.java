class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int max = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while(i <= j){
        int h = Math.min(height[i],height[j]);
        int bredth = j-i;
        area = h * bredth;
        max = Math.max(max, area);

        if(height[i] < height[j])i++;
        else j--;
        }
        return max;
    }
}