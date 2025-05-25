/*
Recursion: explore all path , move in opposite fashion up, left
T.C -> o(n*m)
S -> o(n + m)
 */

class Solution {
    public int minPathSum(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;

         return helper(n-1,m-1, grid);
    }

    int helper(int i, int j, int[][] grid){
        if(i == 0 && j == 0) return grid[0][0];

        if(i < 0 || j < 0) return (int)1e9;

        int up = grid[i][j] + helper(i-1, j, grid);
        int left = grid[i][j] + helper(i, j - 1, grid);

        return Math.min(up, left);
    }
}

/*
Memoize: 
T.C -> o(n*m)
S ->o(n*m) + o(n+m)
 */

class Solution {
    public int minPathSum(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;

         int dp[][] = new int[n][m];

         for(int []row: dp){
            Arrays.fill(row, -1);
         }

         return helper(n-1,m-1, grid, dp);
    }

    int helper(int i, int j, int[][] grid, int dp[][]){
        if(i == 0 && j == 0) return grid[0][0];

        if(i < 0 || j < 0) return (int)1e9;

        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + helper(i-1, j, grid, dp);
        int left = grid[i][j] + helper(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
}


/*
Tabulation: 
T.C -> o(n*m)
S ->o(n*m)
 */

class Solution {
    public int minPathSum(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;

         int dp[][] = new int[n][m]; 

         for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else{
                     int up = grid[i][j];
                    if(i > 0) up += dp[i-1][j];
                    else up += (int)1e9;

                    int left = grid[i][j];
                    if(j > 0) left += dp[i][j-1];
                    else left += (int)1e9;

                    dp[i][j] = Math.min(up, left);
                }
   
            }
         }
     
         return dp[n-1][m-1];
    }
}

/*
Space optimization: 
T.C -> o(n*m)
S ->o(2n)
 */