/*
Approach: pick, no pick horizontal call , and avoid duplicacy at same level
T.C -> 2^n *k
S -> k *x
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, target, new ArrayList<>(), ans, candidates);

        return ans;
    }

    public void helper(int idx, int t, ArrayList<Integer> ds, List<List<Integer>> ans, int []arr){
 
        if(t == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i-1]) continue;

            if(arr[i]<= t){
                ds.add(arr[i]);
                helper(i+1, t - arr[i], ds,ans, arr);
                ds.remove(ds.size()-1);
            }
        }
    }
}