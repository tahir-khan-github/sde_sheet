/*
Approach: find partitions with recursion but do partition only when string is palindrome
T.C -> o(2^n) + o(n/2) + o(k)
S -> o(k * x)
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void helper(String s, int idx, ArrayList<String>ds, List<List<String>> ans){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s, idx, i)){
                ds.add(s.substring(idx, i+1));
                helper(s, i + 1, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }

        return true;
    }
}