class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        
        int oldColor = image[sr][sc];
        change(image, sr, sc, oldColor, color);
        
        return image;
    }
    
    public void change(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        if (sr>0) change(image, sr-1, sc, oldColor, newColor);
        if (sr<image.length-1) change(image, sr+1, sc, oldColor, newColor);
        if (sc>0) change(image, sr, sc-1, oldColor, newColor);
        if (sc<image[0].length-1) change(image, sr, sc+1, oldColor, newColor);
    }
    

}