/*
Approach- pick, no pick reducing target
T.C -> 2^t * k
S -> k * x
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, new ArrayList<>(), ans, candidates);
        
        return ans;
    }

    public void helper(int idx, int t, ArrayList<Integer> ds, List<List<Integer>> ans, int []arr){
        if(idx == arr.length) return;

        if(t == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(arr[idx] <= t){
            ds.add(arr[idx]);
            helper(idx, t - arr[idx], ds, ans, arr);
            ds.remove(ds.size()-1);
        }

        helper(idx + 1, t, ds , ans, arr);
    }
}