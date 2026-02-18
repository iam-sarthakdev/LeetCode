class NeighborSum {
    int arr[][];
    public NeighborSum(int[][] grid) {
        arr=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[i][j]=grid[i][j];
            }
        }
    }
    
    public int adjacentSum(int value) {
        int sum=0;
        int c=0;
        int d=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(value==arr[i][j]){
                    c=i;
                    d=j;
                    break;
                }
            }
        }
        if(c>0) sum+=arr[c-1][d];
        if(c<arr.length-1) sum+=arr[c+1][d];
        if(d>0) sum+=arr[c][d-1];
        if(d<arr.length-1) sum+=arr[c][d+1];
        return sum;
    }
    
    public int diagonalSum(int value) {
        int sum=0;
        int c=0;
        int d=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(value==arr[i][j]){
                    c=i;
                    d=j;
                    break;
                }
            }
        }
        if(c>0 && d<arr.length-1) sum+=arr[c-1][d+1];
        if(c>0 && d>0) sum+=arr[c-1][d-1];
        if(c<arr.length-1 && d<arr.length-1) sum+=arr[c+1][d+1];
        if(c<arr.length-1 && d>0) sum+=arr[c+1][d-1];
        return sum;
    }
}