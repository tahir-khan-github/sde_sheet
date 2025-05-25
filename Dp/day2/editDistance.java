/*
Brute: try all possible ways using recursion
         if match i - 1, j-1
         else 3 operation with index moving
T.C -> exponential
S -> o(n+m)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return helper(n-1, m-1, word1, word2);
    }

    public int helper(int i, int j, String word1, String word2){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(word1.charAt(i) == word2.charAt(j)){
            return 0 + helper(i-1, j-1, word1, word2);
        }

        return Math.min(1 + helper(i, j -1, word1, word2), Math.min(1 + helper(i-1,j, word1, word2), 1 + helper(i-1, j-1, word1, word2)));
    }
}

/*
Memoize:
T.C -> o(n*m)
S-> o(n*m) + o(n+m)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        return helper(n-1, m-1, word1, word2, dp);
    }

    public int helper(int i, int j, String word1, String word2, int [][]dp){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = 0 + helper(i-1, j-1, word1, word2,dp);
        }

        return dp[i][j] = Math.min(1 + helper(i, j -1, word1, word2, dp), Math.min(1 + helper(i-1,j, word1, word2, dp), 1 + helper(i-1, j-1, word1, word2, dp)));
    }
}

/*
Tabulation:
T.C -> o(n*m)
S-> o(n*m)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        
        for(int j = 0 ; j <= m; j++){
            dp[0][j] = j;
        }

        for(int i = 0 ; i <= n; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i<=n ;i++){
            for(int j = 1; j<=m; j++){
                 if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(1 + dp[i][j-1], Math.min(1 + dp[i-1][j], 1 + dp[i-1][j-1]));
                }
            }
        }

        return dp[n][m];
    }
}

/*
Space optimization: 
T.C -> o(n*m)
S -> o(2n)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int curr[] = new int[m+1];
        int prev[] = new int[m+1];
        
        for(int j = 0 ; j <= m; j++){
            prev[j] = j;
        }

        for(int i = 1; i<=n ;i++){
            curr[0] = i;
            for(int j = 1; j<=m; j++){
                 if(word1.charAt(i-1) == word2.charAt(j-1)){
                   curr[j] = 0 + prev[j-1];
                }else{
                   curr[j] = Math.min(1 + curr[j-1], Math.min(1 + prev[j], 1 + prev[j-1]));
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }
}