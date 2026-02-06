class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int originalColor = image[sr][sc];
        dfs(image, sr, sc, color, originalColor);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int newColor, int originalColor){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] == newColor || image[i][j] != originalColor){
            return;
        }

        image[i][j] = newColor;

        // check 4 dirn

        dfs(image, i-1, j, newColor, originalColor);
        dfs(image, i+1, j, newColor, originalColor);
        dfs(image, i, j-1, newColor, originalColor);
        dfs(image, i, j+1, newColor, originalColor);
    }
}