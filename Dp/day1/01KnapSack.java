/*
Brute : take no take , with base at 0 take notake, max of both
T.c -> o(n*w)
S -> o(n*w) + o(n)
 */

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n+1][maxWeight + 1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return helper(n-1,weight, value, maxWeight, dp);

    }

    static int helper(int i,int []wt, int []val, int W, int [][]dp){
        if(i == 0){
            if(wt[0] <= W){
                return val[0];
            }else{
                return 0;
            }
        }

        if(dp[i][W] != -1){
            return dp[i][W];
        }

        int take = Integer.MIN_VALUE;
        if(wt[i] <= W){
            take = val[i] + helper(i - 1, wt, val, W - wt[i],dp);
        }

        int no_take = 0 + helper(i-1, wt, val, W, dp);

        return dp[i][W] = Math.max(take, no_take);
    }
}

/*
Tabulation: handle base case
            write changing parms in opposite fashion
            copy recursion code
 */

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n+1][maxWeight + 1];
        
        for(int W = weight[0]; W <= maxWeight; W++){
            dp[0][W] = value[0];
        }

        for(int i = 1; i < n; i++){
            for(int W = 0; W <= maxWeight; W++){
                int take = Integer.MIN_VALUE;
                if(weight[i] <= W){
                    take = value[i] + dp[i - 1][W - weight[i]];
                }

                int no_take = 0 + dp[i-1][W];

                dp[i][W] = Math.max(take, no_take);
            }
        }

        return dp[n-1][maxWeight];

    }

/*
Space optimization: i-1 -> prev , i -> curr
 */