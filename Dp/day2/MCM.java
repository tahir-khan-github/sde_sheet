/*
Recursion: steps = arr[i-1] * arr[k] * arr[j] + f(i,k) + f(k+1, j)
T.C -> exponential
 */

class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        
        return helper(1, n-1, arr);
    }
    
    static int helper(int i, int j, int[] arr){
        if(i == j) return 0;
        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + helper(i, k, arr) + helper(k+1, j, arr);
            mini = Math.min(mini, steps);
        }
        
        return mini;
    }
}

/*
Memoize:
T.c ->o(n*m)
S-> o(n*m) + stack space
 */

class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        return helper(1, n-1, arr, dp);
    }
    
    static int helper(int i, int j, int[] arr, int dp[][]){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + helper(i, k, arr,dp) + helper(k+1, j, arr, dp);
            mini = Math.min(mini, steps);
        }
        
        return dp[i][j] = mini;
    }
}

/*
Tabulation:
T.c ->o(n*m)
S-> o(n*m) 
 */

class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = 0;
        }
        
        for(int i = n-1; i >= 1; i--){
            for(int j = i+1; j < n ; j++){
                 int mini = Integer.MAX_VALUE;
                for(int k = i; k <= j-1; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini, steps);
                }
                 dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
    
}