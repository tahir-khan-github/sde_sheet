/*
Approach: vis, 8 direction using loop
T.C -> n"*m*9
S -> 2 * n * m
 */
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    cnt++;
                    dfs(i,j, vis,grid,n,m);
                }
            }
        }

        

        return cnt;
    }

    public void dfs(int row, int col, boolean vis[][],char[][] grid,int n, int m){
        vis[row][col] = true;

        for(int i = -1 ; i <=1 ; i++){
            for(int j = -1 ; j <= 1 ; j++){
                int nr = row + i;
                int nc = col + j;
                if((nr >= 0 && nr < n) && (nc >= 0 && nc < m) && vis[nr][nc] == false && grid[nr][nc] == '1'){
                    dfs(nr,nc,vis,grid,n,m);
                }
            }
        }
    }
}