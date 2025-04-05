/*
Brute: genrate all substring using 2loops and check each string is palindrome(2pointer) or not
T.C -> n^3
S ->1
 */
class Solution {
    public String longestPalindrome(String s) {
        int sp = 0, maxLen = 0;

        for(int i = 0 ; i < s.length(); i++){
            for(int j = i ; j< s.length() ; j++){
                if(isPalindrome(i, j, s)){
                    if (j - i + 1 > maxLen) { // Update only if a longer palindrome is found
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp,sp + maxLen);
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }
}

/*
Optimal:axis orbit startegy
T.C -> n^2
s -> 1
 */
class Solution {
    public String longestPalindrome(String s) {
        int sp = 0, maxLen = 0;

        //odd length lps
        for(int ax = 0 ; ax < s.length(); ax++){
            int ob = 1;
            int len = 1;

            while(ax-ob >= 0 && ax+ob < s.length()){
                if(s.charAt(ax-ob) == s.charAt(ax+ob)){
                    ob++;
                    len += 2;
                }else{
                    break;
                }
            } 
            if(len  > maxLen){
                sp = ax - len/2;
                maxLen = len;
            }
        }

          //even length lps
        for(int ax = 0 ; ax < s.length() -1; ax++){
            int ob = 1;
            int len = 0;

            while(ax-ob +1 >= 0 && ax+ob < s.length()){
                if(s.charAt(ax-ob+1) == s.charAt(ax+ob)){
                    ob++;
                    len += 2;
                }else{
                    break;
                }
            } 
            if(len  > maxLen){
                sp = ax - len/2 +1;
                maxLen = len;
            }
        }

        return s.substring(sp,sp + maxLen);
    }
}