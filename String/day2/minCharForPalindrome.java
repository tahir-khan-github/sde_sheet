/*
Appraoch: find the difference between the length of the string with the common string, this can be achieved by lps
T.C -> o(n)
s -> o(n)
 */
class Solution {
    public static int minChar(String s) {
        String str = s +"$"+ new StringBuilder(s).reverse().toString();
        
        int lps[] = computeLps(str);
        
        return s.length() - lps[str.length() - 1];
    }
    
    public static int[] computeLps(String pat){
        int len = 0;
        int i = 1;
        int lps[] = new int[pat.length()];
        lps[0] = 0;
        
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    i++;
                }
            }
        }
        
        return lps;
    }
}