/*
Recursion: take no_take
T.C -> exponential
S -> (target)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int ans = helper(n-1,coins,amount);
        if(ans == (int)Math.pow(10,9)) return -1 ;
        return ans;

    }

    int helper(int i, int[] coins, int amount){
        if(i == 0){
            if(amount % coins[i] == 0){
                return amount/coins[0];
            }else{
                return (int)Math.pow(10,9);
            }
        }

        int take = (int)Math.pow(10,9);
        if(coins[i] <= amount){
            take = 1 + helper(i, coins, amount - coins[i]);
        }

        int no_take = 0 + helper(i-1, coins, amount);

        return Math.min(take, no_take);
    }
}

/*
Memoize: 
T.C -> o(n*m)
S-> o(n*m) + o(target)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n][amount + 1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }

        int ans = helper(n-1,coins,amount, dp);
        if(ans == (int)Math.pow(10,9)) return -1 ;
        return ans;

    }

    int helper(int i, int[] coins, int amount, int [][]dp){
        if(i == 0){
            if(amount % coins[i] == 0){
                return amount/coins[0];
            }else{
                return (int)Math.pow(10,9);
            }
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int take = (int)Math.pow(10,9);
        if(coins[i] <= amount){
            take = 1 + helper(i, coins, amount - coins[i], dp);
        }

        int no_take = 0 + helper(i-1, coins, amount, dp);

        return dp[i][amount] =  Math.min(take, no_take);
    }
}

/*
Tabulaton:
T.C -> o(n*m)
S-> o(n*m)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n][amount + 1];

        for(int A = 0; A <= amount; A++){
            if(A % coins[0] == 0){
                dp[0][A] = A/coins[0];
            }else{
                dp[0][A] = (int)Math.pow(10,9);
            }
        }

        for(int i = 1; i < n ; i++){
            for(int A = 0; A <= amount; A++){
                int take = (int)Math.pow(10,9);
                if(coins[i] <= A){
                    take = 1 + dp[i][A - coins[i]];
                }

                int no_take = 0 + dp[i-1][A];

               dp[i][A] =  Math.min(take, no_take);
            }
        }

        int ans = dp[n-1][amount];
        if(ans == (int)Math.pow(10,9)) return -1 ;
        return ans;

    }
}

/*
Space optimization:
T.C -> o(n*m)
S-> o(2n)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];

        for(int A = 0; A <= amount; A++){
            if(A % coins[0] == 0){
                prev[A] = A/coins[0];
            }else{
                prev[A] = (int)Math.pow(10,9);
            }
        }

        for(int i = 1; i < n ; i++){
            for(int A = 0; A <= amount; A++){
                int take = (int)Math.pow(10,9);
                if(coins[i] <= A){
                    take = 1 + curr[A - coins[i]];
                }

                int no_take = 0 + prev[A];

               curr[A] =  Math.min(take, no_take);
            }

            prev = curr;
        }

        int ans = prev[amount];
        if(ans == (int)Math.pow(10,9)) return -1 ;
        return ans;

    }
}