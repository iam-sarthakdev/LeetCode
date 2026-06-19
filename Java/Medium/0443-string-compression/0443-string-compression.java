class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;

        int n = chars.length;
        while(i < n){
            char currentChar = chars[i];
            int count = 0;

            while(i < n && chars[i] == currentChar){
                i++;
                count++;
            }
            chars[j++] = currentChar;

            if(count > 1){
                for(char s : String.valueOf(count).toCharArray()){
                    chars[j++] = s;
                }
            }
        }
        return j;
    }
}