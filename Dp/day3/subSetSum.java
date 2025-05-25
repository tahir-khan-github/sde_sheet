/*
Recursoion: take, no_take
T.C -> 2^n
S -> o(n)
 */

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        
        return helper(n-1, sum, arr);
    }
    
    static Boolean helper(int i,int sum, int []arr){
        if(sum == 0) return true;
        if(i == 0) return arr[0] == sum;
        
        boolean take = false;
        
        if(arr[i] <= sum){
            take = helper(i- 1, sum - arr[i], arr);
        }
        boolean no_take = helper(i-1, sum, arr);
        
        return take || no_take;
    }
}

/*
memoization: 
T.c -> o(n*m)
S-> o(n*m) + o(n)
 */

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        
        Boolean [][]dp = new Boolean[n][sum + 1];
        
        return helper(n-1, sum, arr, dp);
    }
    
    static Boolean helper(int i,int sum, int []arr, Boolean [][]dp){
        if(sum == 0) return true;
        if(i == 0) return arr[0] == sum;
        
        if(dp[i][sum] != null) return dp[i][sum];
        
        boolean take = false;
        
        if(arr[i] <= sum){
            take = helper(i- 1, sum - arr[i], arr, dp);
        }
        boolean no_take = helper(i-1, sum, arr, dp);
        
        return dp[i][sum] = take || no_take;
    }
}

/*
tabulation: dp[0][a[0]] = true
T.c -> o(n*m)
s -> o(n*m)
 */

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        
        boolean [][]dp = new boolean[n][sum + 1];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        
       if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        
        for(int i = 1; i < n ; i++){
            for(int t = 1; t <= sum; t++){
                 boolean take = false;
        
                if(arr[i] <= t){
                    take = dp[i- 1][t - arr[i]];
                }
                boolean no_take = dp[i-1][t];
                
                dp[i][t] = take || no_take;
            }
        }
         
        return dp[n-1][sum];
    }
}

/*
Space optimizaton:
T.C -> o(n*m)
S -> o(2n)
 */

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        
        boolean []prev = new boolean[sum + 1];
        boolean []curr = new boolean[sum + 1];
        
        prev[0] = true;

        
       if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }
        
        for(int i = 1; i < n ; i++){
            
            curr[0] = true;
            
            for(int t = 1; t <= sum; t++){
                 boolean take = false;
        
                if(arr[i] <= t){
                    take = prev[t - arr[i]];
                }
                boolean no_take = prev[t];
                
                curr[t] = take || no_take;
            }
            boolean temp[] = prev;
            prev = curr;
            curr = temp;
        }
         
        return prev[sum];
    }
}