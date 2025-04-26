/*
Approach: check for left and right val
            check left -> left == right.left & check left.right == right == right

T.C -> o(n)
S -> o(n) 
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if((left.val == right.val) &&  helper(left.left, right.right) && helper(left.right, right.left)){
            return true;
        }

      return false;
    }
}