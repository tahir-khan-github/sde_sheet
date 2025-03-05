/*
Approach: pick, no pick
T.C -> 2^n + 2^nlog2^n,
S-> 2^n
 */

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0,0,arr, ans);
        Collections.sort(ans);
        
        return ans;
    }
    
    public void helper(int idx, int sum, int[] arr, ArrayList<Integer> ans){
        if(idx >= arr.length){
            ans.add(sum);
            return;
        }
        
        helper(idx+1, sum + arr[idx], arr, ans);
        helper(idx+1, sum, arr, ans);
    }
}