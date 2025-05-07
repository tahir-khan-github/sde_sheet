/*
Appraoch: vis, 8 direction using loop
T.C -> n"*m*9
S -> 2 * n * m
 */

class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

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
                    bfs(i,j, vis,grid,n,m);
                }
            }
        }

        

        return cnt;
    }

    public void bfs(int i, int j, boolean vis[][],char[][] grid,int n, int m){
       Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
         int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair temp  = q.remove();
            int row = temp.row;
            int col = temp.col;
            
         for (int k = 0; k < 4; k++) {
                int nr = row + dRow[k];
                int nc = col + dCol[k];
                if((nr >= 0 && nr < n) && (nc >= 0 && nc < m) && vis[nr][nc] == false && grid[nr][nc] == '1'){
                   vis[nr][nc] = true;
                   q.add(new Pair(nr, nc));
                }
            }
        }
    }
}