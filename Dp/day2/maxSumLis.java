
/*
Better: pick, nopick, prev, dp
T.C -> o(n*m), s-> o(n*m) + o(n)
 */

class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        // We use dp[i][prev+1] to memoize results
        int[][] dp = new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, -1, arr, dp);
    }

    private int helper(int i, int prev, int[] arr, int[][] dp) {
        if (i >= arr.length) return 0;

        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];

        int take = 0, noTake = 0;

        // If we can take the current element
        if (prev == -1 || arr[i] > arr[prev]) {
            take = arr[i] + helper(i + 1, i, arr, dp);
        }

        // Option to skip current element
        noTake = helper(i + 1, prev, arr, dp);

        return dp[i][prev + 1] = Math.max(take, noTake);
    }
}

/*
More Better : tabulation:
            1)handle base case
            2)write changing params in opposite fashion
            3)copy recursion
T.C -> o(n*m), s-> o(n*m)
 */
class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        // We use dp[i][prev+1] to memoize results
        int[][] dp = new int[n  + 1][n+1];
        
        for(int i = n - 1; i >=0 ; i--){
            for(int prev = i - 1; prev >= -1; prev--){
                  int take = 0, noTake = 0;

                    if (prev == -1 || arr[prev] < arr[i]) {
                        take = arr[i] + dp[i + 1][i+1];
                    }
            
                    noTake = dp[i+1][prev + 1];
                    
                    dp[i][prev + 1] = Math.max(take, noTake);
            }
        }
        
        return dp[0][-1+1];
    }

}

/*
optimal: 1) convert 2d to 2 1d curr & next
            2) replace index + 1 with next and index with curr
            3)after each iteration mark next = curr
            4)retun curr
T.c -> o(n*m), S-> o(2n)
 */

class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        // We use dp[i][prev+1] to memoize results
        int[] curr = new int[n  + 1];
        int[] next = new int[n  + 1];
        
        for(int i = n - 1; i >=0 ; i--){
            for(int prev = i - 1; prev >= -1; prev--){
                  int take = 0, noTake = 0;

                    if (prev == -1 || arr[prev] < arr[i]) {
                        take = arr[i] + next[i+1];
                    }
            
                    noTake = next[prev + 1];
                    
                    curr[prev + 1] = Math.max(take, noTake);
            }
            next = curr;
        }
        
        return next[-1+1];
    }

}
