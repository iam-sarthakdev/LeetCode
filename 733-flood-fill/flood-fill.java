class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;

        bfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void bfs(int[][] image, int i, int j, int originalColor, int color){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length){
            return;
        }

        if(image[i][j] != originalColor){
            return;
        }

        image[i][j] = color;

        // now check all 4 directions

        bfs(image, i+1, j, originalColor, color);
        bfs(image, i-1, j, originalColor, color);
        bfs(image, i, j+1, originalColor, color);
        bfs(image, i, j-1, originalColor, color);
    }
}