/*
brute: generate all substrings like subarray using 2 loops, just use set to check for repeat and whenever we found repeat we can break
and count maxlen
T.C -> o(n^2)
S->o(n)
 */
{
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int n = s.length();
        int maxlen = 0;
        for(int i = 0 ; i < n ; i++){
            Set<Character> set = new HashSet<>();
            for(int j = i ; j < n; j++){
                if(set.contains(s.charAt(j))){
                    maxlen = Math.max(maxlen, j - i);
                    break;
                }
                set.add(s.charAt(j));
            }
        }

        return maxlen;
    }
}

/*
optimal: twopointer, sliding window and fmap 
 */

{
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int n = s.length();
        int maxlen = 0;
        int len = 0;
        int fmap[] = new int[256];
        Arrays.fill(fmap, -1);
        int l = 0, r=0;

        while(r < n){
            if(fmap[s.charAt(r)] != -1){
                if(fmap[s.charAt(r)] >= l){
                    l = fmap[s.charAt(r)]  + 1;
                }
            }
            len = r - l + 1;
            maxlen = Math.max(maxlen, len);
            fmap[s.charAt(r)] = r;
            r++;
        }


        return maxlen;
    }
}