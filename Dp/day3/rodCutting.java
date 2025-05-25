/*
Recursion : take, no_take
T.c -> o(exponential)
S -> o(target)
 */
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;

        
        return helper(n-1, n, price);
    }
    
    int helper(int i, int N, int []price){
        if(i == 0) return N * price[0];
        
        int rodlen = i + 1;
        int take = Integer.MIN_VALUE;
        if(rodlen <= N){
            take = price[i] + helper(i, N - rodlen, price);
        }
        int no_take = 0 + helper(i - 1, N, price);
        
        return Math.max(take, no_take);
    }
}



/*
memoize : take, no_take
T.c -> o(n*m)
S -> o(n*m) + o(target)
 */

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int dp[][] = new int[n][n+1];
        
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        
        return helper(n-1, n, price, dp);
    }
    
    int helper(int i, int N, int []price, int [][]dp){
        if(i == 0) return N * price[0];
        
        if(dp[i][N] != -1) return dp[i][N];
        
        int rodlen = i + 1;
        int take = Integer.MIN_VALUE;
        if(rodlen <= N){
            take = price[i] + helper(i, N - rodlen, price, dp);
        }
        int no_take = 0 + helper(i - 1, N, price, dp);
        
        return dp[i][N] = Math.max(take, no_take);
    }
}

/*
Tabulation: N*arr[0]
 T.c -> o(n*m)
S -> o(n*m)
 */
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int dp[][] = new int[n][n+1];
        
        for(int N = 0; N <= n; N++){
            dp[0][N] = N * price[0];
        }
        
        for(int i = 1; i < n; i++){
            for(int N = 1; N <= n ; N++){
                int rodlen = i + 1;
                int take = Integer.MIN_VALUE;
                if(rodlen <= N){
                    take = price[i] + dp[i][N - rodlen];
                }
                int no_take = 0 + dp[i - 1][N];
                
              dp[i][N] = Math.max(take, no_take);
            }
        }
   
        
        return dp[n-1][n];
    }
    
}

/*
Space optimization
 T.c -> o(n*m)
S -> o(2n)
 */

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];
        
        for(int N = 0; N <= n; N++){
            prev[N] = N * price[0];
        }
        
        for(int i = 1; i < n; i++){
            for(int N = 1; N <= n ; N++){
                int rodlen = i + 1;
                int take = Integer.MIN_VALUE;
                if(rodlen <= N){
                    take = price[i] + curr[N - rodlen];
                }
                int no_take = 0 + prev[N];
                
              curr[N] = Math.max(take, no_take);
            }
            int temp[] = prev;
            prev = curr;
            curr = temp;
        }
   
        
        return prev[n];
    }
    
}