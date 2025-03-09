/*
brute: generate all substrings like subarray using 2 loops, just use set to check for repeat and whenever we found repeat we can break
and count maxlen
T.C -> o(n^2)
S->o(n)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int n = s.length();
        int maxlen = 0;

        for(int i = 0 ; i < s.length(); i++){
                int fmap[] = new int[256];
                for(int j = i; j < s.length(); j++){
                    if(fmap[s.charAt(j)] == 1) break;
                    maxlen = Math.max(maxlen, j - i + 1);
                    fmap[s.charAt(j)] = 1;
                }
        }

       

        return maxlen;
    }
}

/*
optimal: twopointer, sliding window and fmap 
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int n = s.length();
        int maxlen = 0;
        int fmap[] = new int[256];
        Arrays.fill(fmap, -1);
        int l = 0, r = 0;

        while(r < n){
            if(fmap[s.charAt(r)] != -1){
                if(fmap[s.charAt(r)] >= l){
                    l = fmap[s.charAt(r)] + 1;
                }
            }

            maxlen = Math.max(maxlen, r - l + 1);
            fmap[s.charAt(r)] = r;
            r++;
        }

       

        return maxlen;
    }
}