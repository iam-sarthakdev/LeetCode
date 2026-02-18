class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m=s.length();
        int[] res=new int[m];
        
        for(int i=0;i<m;i++){
            int count=0,a=startPos[0],b=startPos[1];
            for(int j=i;j<m;j++){
                char c=s.charAt(j);
                if(c=='R') b++;
                if(c=='L') b--;
                if(c=='U') a--;
                if(c=='D') a++;
                if(a<0 || a>=n || b<0 || b>=n) break;
                count++;
            }
            res[i]=count;
        }
        return res;

    }
}