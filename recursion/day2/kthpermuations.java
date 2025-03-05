/*
Brute: generate all permutation, sort the ans return k-1
T.C-> o(n! * n) + n!logn!
S -> o(n!)
 */
class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<String> ans = new ArrayList<>();
        String s = new String();
        for(int i = 1; i <= n ; i++){
            s += i;
        }
        helper(s.toCharArray(), 0, ans);
        Collections.sort(ans);
        return ans.get(k-1);
    }
    public void helper(char s[], int idx, ArrayList<String> ans){
        if (idx == s.length) {
            String str = new String(s);
            ans.add(str);
            return;
        }

        for(int i = idx; i < s.length; i++){
            swap(s, idx, i);
            helper(s, idx +1, ans);
            swap(s, idx, i);
        }
    }

    public void swap(char s[], int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}