/*
Approach: make horizontal pick/mo pick call call, also skip duplicates at same level
T.C -> 2^n + nlogn + n
S -> 2^n *k;
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,new ArrayList<>(), ans, nums);

        return ans;
    }

    public void helper(int idx, ArrayList<Integer> ds, List<List<Integer>> ans, int[] nums){
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i < nums.length; i++){
             if(i > idx && nums[i] == nums[i - 1]) continue;
                ds.add(nums[i]);
                helper(i+1, ds, ans, nums);
                ds.remove(ds.size()-1);
  
        }
    }
}