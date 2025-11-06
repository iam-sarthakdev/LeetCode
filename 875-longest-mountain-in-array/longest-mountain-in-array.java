class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i - 1] < arr[i] && arr[i+1] < arr[i]){
                int left = i - 1;
                int right = i + 1;

                while(left > 0 && arr[left - 1] < arr[left]) left--;
                while(right < n - 1 && arr[right + 1] < arr[right]) right++;
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}