/*
Recursin : check all floors using k loop and check for up(e, f-k) or down(e-1, k-1)
T.c-> exponential
S-> o(e+f)
 */

class Solution {
    static int eggDrop(int n, int k) {
       int e =n;
       int f = k;
       return helper(e,f);
    }
    
    static int helper(int e, int f){
        if(e == 1) return f;
        if(f == 0 || f == 1) return f;
        int mini = Integer.MAX_VALUE;
        
        for(int k = 1; k <= f; k++){
            int temp = 1 + Math.max(helper(e-1, k-1) , helper(e, f-k));
            mini = Math.min(mini, temp);
        }
        
        return mini;
    }
}

/*
memoization
T.c-> o(n*m)
S -> o(n*m) + o(e+f)
 */

class Solution {

    static int eggDrop(int n, int k) {
       int e =n;
       int f = k;
       int dp[][] = new int[e+1][f+1];
       for(int row[]: dp){
           Arrays.fill(row, -1);
       }
       return helper(e,f,dp);
    }
    
    static int helper(int e, int f, int dp[][]){
        if(e == 1) return f;
        if(f == 0 || f == 1) return f;
        
        if(dp[e][f] != -1) return dp[e][f];
        int mini = Integer.MAX_VALUE;
        
        for(int k = 1; k <= f; k++){
            int temp = 1 + Math.max(helper(e-1, k-1, dp) , helper(e, f-k, dp));
            mini = Math.min(mini, temp);
        }
        
        return dp[e][f] = mini;
    }
}


/*
tabulation:
T.c-> o(n*m)
S -> o(n*m)
 */
class Solution {

    static int eggDrop(int n, int k) {
       int e =n;
       int f = k;
       int dp[][] = new int[e+1][f+1];
       
       for(int j = 0; j<= f; j++){
           dp[1][j] = j;
       }
       
       for(int i = 1 ; i <= e ;i++){
           dp[i][0] = 0;
           dp[i][1] = 1;
       }
       
       for(int i = 2; i<= e; i++){
           for(int j = 2; j<= f; j++){
               int mini = Integer.MAX_VALUE;
        
               for(int L = 1; L <= j; L++){
                    int temp = 1 + Math.max(dp[i-1][L-1] , dp[i][j-L]);
                    mini = Math.min(mini, temp);
                }
                
               dp[i][j] = mini;
           }
       }
       
       return dp[e][f];
    }
}


/*
space optimization:
T.c-> o(n*m)
S -> o(2n)
 */
class Solution {

    static int eggDrop(int n, int k) {
       int e =n;
       int f = k;
       int prev[] = new int[f+1];
       int curr[] = new int[f+1];
       
       
       
       for(int j = 0; j<= f; j++){
          prev[j] = j;
       }
 
       
       for(int i = 2; i<= e; i++){
           curr[0] = 0;
           for(int j = 1; j<= f; j++){
               int mini = Integer.MAX_VALUE;
        
               for(int L = 1; L <= j; L++){
                    int temp = 1 + Math.max(prev[L-1] , curr[j-L]);
                    mini = Math.min(mini, temp);
                }
                
               curr[j] = mini;
           }
           int temp[] = prev;
           prev = curr;
           curr = temp;
       }
       
       return prev[f];
    }
}