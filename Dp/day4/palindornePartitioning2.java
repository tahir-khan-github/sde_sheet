/*
Recursion: cut at k i to j-1
T.c -> o(n*2^n)
S -> o(n)
 */

class Solution {
    public int minCut(String s) {

        return helper(0, s.length() -1, s, dp);
    }

    int helper(int i, int j, String s, int dp[][]){
        if(i >= j) return 0;

        if(isPalindrome(i, j, s)){
            return 0;
        }


        int mini = Integer.MAX_VALUE;

        for(int k = i ; k <= j -1; k++){
            int cut = 1 + helper(i, k, s, dp) + helper(k+1, j, s, dp);
               mini = Math.min(mini, cut);
        }

        return  mini;
    }

    boolean isPalindrome(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}

/*
memoize:
T.C -> o(n*m *n)
S -> O(n*m) + o(n)
 */

class Solution {
    public int minCut(String s) {

        int dp[][] = new int[s.length() + 1][s.length() + 1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        return helper(0, s.length() -1, s, dp);
    }

    int helper(int i, int j, String s, int dp[][]){
        if(i >= j) return 0;

        if(isPalindrome(i, j, s)){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for(int k = i ; k <= j -1; k++){
            int cut = 1 + helper(i, k, s, dp) + helper(k+1, j, s, dp);
               mini = Math.min(mini, cut);
        }

        return dp[i][j] = mini;
    }

    boolean isPalindrome(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}

/*
Tabulation:
T.C -> o(n^3)
S -> o(n*m) 
 */
class Solution {
    public int minCut(String s) {

        int dp[][] = new int[s.length() + 1][s.length() + 1];
     
        for(int i = s.length() -1; i>=0; i--){
            for(int j = 0 ; j < s.length() ; j++){
                if(i >= j) dp[i][j] = 0;
                if(isPalindrome(i, j, s)){
                        dp[i][j] = 0;
                }else{
                     int mini = Integer.MAX_VALUE;

                    for(int k = i ; k <= j -1; k++){
                        int cut = 1 + dp[i][k] + dp[k+1][j];
                        mini = Math.min(mini, cut);
                    }

                    dp[i][j] = mini;
                }
                
            }
        }

        return dp[0][s.length() -1];
    }


    boolean isPalindrome(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}