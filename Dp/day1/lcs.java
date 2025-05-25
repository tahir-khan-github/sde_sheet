/*
Brute + better -> recursion call with match and no match , with dp
            if match 1 + f(reduce both strings)
            if no match 0 + (reduce one at a time)

T.C -> o(n*m)
S -> o(n*m) + o(n + m)
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];

       for(int row[]: dp){
        Arrays.fill(row, -1);
       }

        return helper(n-1, m-1, text1, text2, dp);
    }

    int helper(int idx1, int idx2, String s1, String s2, int dp[][]){
        if(idx1 < 0 || idx2 < 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + helper(idx1-1, idx2 - 1, s1, s2, dp);
        }

        return dp[idx1][idx2] = Math.max(helper(idx1 - 1, idx2, s1, s2, dp), helper(idx1, idx2 - 2, s1, s2, dp));
    }
}

/*
Tabulation: 
        1)handle base case i < 0 || j < 0 (i & j can be -1) which is not possible in terms of dp, so we do index shift
            -1 -> 0
            0 - > 1
            n-1 -> n
            m-1 -> m
        dp[i][0] = 0, dp[0][j] = 0
        
        2)write changing params in opposite fashion
        3)write recursion code
T.C -> o(n*m)
S-> 0(n*m)
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n +1][m + 1];

        for(int i = 0 ; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ; j <= m; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                   dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}

/*
Space optimization: i-1 -> prev, i -> curr
T.C -> o(n*m)
S-> 0(2m)
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int prev[] = new int[m +1];
        int curr[] = new int[m +1];


        for(int j = 0 ; j <= m; j++){
            prev[j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                   curr[j] = 1 + prev[j-1];
                }else{
                     curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
          int[] temp = prev;
            prev = curr;
            curr = temp;
            Arrays.fill(curr, 0); // Reset for next use
        }

        return prev[m];
    }
}

/*
Printing lcs : trace back dp
 */

    StringBuilder sb = new StringBuilder();
        int i = n, j = m;
       while(i > 0 && j >0){
          if(text1.charAt(i - 1) == text2.charAt(j - 1)){
            sb.append(text1.charAt(i - 1));
            i--;
            j--;
          }else if(dp[i-1][j] > dp[i][j - 1]){
            i--;
          }else{
            j--;
          }
       }

       
          System.out.println(sb.reverse().toString());