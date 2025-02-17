/*
Brute: user recursion to find all possible combination
T.C -> exponential in nature
S -> exponential in nature
 */
 {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }

    public int helper(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        else return helper(i+1,j,m,n) + helper(i,j+1,m,n);
    }
}

/*
Better : using dp
T.C -> o(n*m)
S-> o(n*m)
 */
{
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(0,0,m,n, dp);
    }

    public int helper(int i, int j, int m, int n, int dp[][]){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        else return dp[i][j] = helper(i+1,j,m,n,dp) + helper(i,j+1,m,n, dp);
    }
}

/*
optimal: By converting problem into nCr
where n = (m+n-2)total paths, r = (m-1)right or (n-1)down
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r = Math.min(m - 1, n - 1);
        long res = 1;
        for(int i = 1; i <= r; i++){
            res = res * (N - r + i);
            res = res / i;
        }

        return (int)res;
    }
}