/*
Approach: range property of bst [-max, node] [node, max]
T.c -> o(n)
S -> o(1)
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode root, int min, int max){
        if(root == null) return true;

        if(root.val < min || root.val > max) return false;

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left && right;
    }
}