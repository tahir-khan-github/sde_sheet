/*
Brute: check for each character n*m
 */

/*
Optimal: use kmp which works on lps(longest prefix suffix)
T.c -> o(n+m)
S -> o(m)
 */
class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int lps[] = lps(pat);
        int i =0;
        int j =0;
        
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            
            if(j == pat.length()){
                ans.add(i - j);
                j = lps[j-1];
            }else if(txt.charAt(i) != pat.charAt(j)){
                if(j-1 > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        
        for(int k = 0 ; k < ans.size(); k++){
            System.out.print(ans.get(k));
        }
        
        return ans;
    }
    
    int[] lps(String pat){
        int len = 0;
        int i = 1;
        int lps[]  = new int[pat.length()];
        lps[0] = 0;
        
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len - 1 > 0){
                    len = lps[len -1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}