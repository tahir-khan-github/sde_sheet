/*
Approach: observe pattern i.e we repeat 1st string till length of 2nd string either it will match, else increase one more time and again
match
T.C -> 2(n+m) + m `= (n+m)
S -> m
 */

class Solution {
    public int repeatedStringMatch(String a, String b) {
        String temp = a;
        int times = 1;

        while(temp.length() < b.length()){
            temp += a;
            times++;
        }

        if(kmpSearch(temp,b)){
            return times;
        }

        temp += a;
        times++;

        if(kmpSearch(temp,b)){
            return times;
        }

        return -1;
    }

    public boolean kmpSearch(String txt, String pat){
        int i = 0 , j = 0;
        int lps[] = computeLps(pat);

        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }

            if(j == pat.length()){
                return true;
            }else if(i < txt.length() && txt.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }

        return false;
    }

    public int[] computeLps(String pat){
        int len = 0;
        int lps[] = new int[pat.length()];
        lps[0] = 0;
        int i = 1;

        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
               if(len != 0){
                 len = lps[len - 1];
               }else{
                lps[i] =0;
                i++;
               }
            }
        }

        return lps;
    }
}