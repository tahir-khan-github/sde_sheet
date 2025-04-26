/*
Appraoch: dfs traversal, check for valid condition and go 4 side
T.C -> o(4*n*m)
s-> (n*m) + (n*m)
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        int []dRow = {-1, 0, 1, 0};
        int []dCol = {0,1,0, -1};
        for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < m ; j++){
                ans[i][j] = image[i][j];        
            }
        }

        int initialColor = image[sr][sc];

        dfs(sr, sc, ans, image, dRow, dCol, color, initialColor, n, m);

        return ans;
    }

    void dfs(int row, int col, int [][]ans, int [][]image, int[] dRow, int []dCol, int newColor, int iniColor, int n, int m){
        ans[row][col] = newColor;
        
        for(int i = 0 ; i < 4; i++){
            int nrow = row + dRow[i];
            int ncol = col + dCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && ans[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                dfs(nrow, ncol, ans, image,dRow, dCol, newColor, iniColor, n, m);
            }
        }

    }
}