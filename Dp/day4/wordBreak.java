/*
Recursion: break string at each length and check in hashmap
T.C -> n*2^n
S -> o(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        return helper(0, s, set);
    }

    boolean helper(int idx, String s,  HashSet<String> set){
        if(idx >= s.length()) return true;

        if(set.contains(s)) return true;

        for(int len = idx + 1; len <= s.length(); len++){
            String temp = s.substring(idx, len);
            if(set.contains(temp) && helper(len, s, set)){
                return true;
            }
        }

        return false;
    }
}


/*
memoize: break string at each length and check in hashmap
T.C -> o(n*m)
S -> o(n) + o(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        Boolean dp[] = new Boolean[s.length()];

        return helper(0, s, set, dp);
    }

    boolean helper(int idx, String s,  HashSet<String> set, Boolean[] dp){
        if(idx >= s.length()) return true;

        if(set.contains(s)) return dp[idx] = true;

        if(dp[idx] != null) return dp[idx];

        for(int len = idx + 1; len <= s.length(); len++){
            String temp = s.substring(idx, len);
            if(set.contains(temp) && helper(len, s, set, dp)){
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}

/*
Tabulation:
T.C -> o(n*m)
s-> o(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        boolean dp[] = new boolean[s.length()+1];
        Arrays.fill(dp, false);

        dp[s.length()] = true;

        for(int idx = s.length(); idx >= 0; idx--){
            for(int len = idx + 1; len <= s.length(); len++){
                String temp = s.substring(idx, len);
                if(set.contains(temp) && dp[len]){
                    dp[idx] = true;
                }
            }
        }

        return dp[0];
    }
}