/*
Approach: find all the sentense using recursion and back tracking
T.C -> 2^n
S -> o(n)
 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }

        solve(0, s, "",set, ans);

        return ans;
    }

    public void solve(int i, String s, String currString,HashSet<String> set,List<String> ans){
        if(i >= s.length()){
            ans.add(currString);
            return;
        }

        for(int j = i; j < s.length() ; j++){
            String word = s.substring(i, j+1);
            if(set.contains(word)){
                String temp = currString;
                if(currString != ""){
                    currString += " ";
                }
                currString += word;
                solve(j+1, s, currString, set, ans);
                currString = temp;
            }
        }
    }
}