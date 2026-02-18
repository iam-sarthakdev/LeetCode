class Solution {
    public int[] executeInstructions(int n, int[] pos, String s) {
        int len=s.length();
        int result[]=new int[len];
        int row=pos[0];
        int col=pos[1];
        int count=0;
        for(int i=0;i<len;i++){
            row=pos[0];
            col=pos[1];
            count=0;;
            for(int j=i;j<len;j++){
                char ch=s.charAt(j);
                if(ch=='U')row--;
                else if(ch=='D')row++;
                else if(ch=='L')col--;
                else col++;
                if(row<0||col<0||row>=n||col>=n)break;
                count++;
            }
            result[i]=count;
        }
        return result;
    }
}