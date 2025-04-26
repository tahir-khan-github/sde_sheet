/*
Appraoch: inorder ,add node val into list, and if false remove last elem and if target found start returning true
T.C -> o(n)
S -> o(h)
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(A, B, ans);
        
        return ans;
    }
    
    public Boolean helper(TreeNode node, int target, ArrayList<Integer> list){
        if(node == null) return false;
        
        list.add(node.val);
        if(node.val == target) return true;
        
        boolean leftCall = helper(node.left, target, list);
        boolean rightCall = helper(node.right, target, list);
        
        if(leftCall || rightCall){
             return true;
        }
        
        list.remove(list.size() - 1);
        
        return false;
    }
}
