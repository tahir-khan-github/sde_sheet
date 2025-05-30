/*
Appraoch: L < Root < R
T.c-> o(log^2H)
S -> o(log^2H)
 */

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(val == root.val) return root;

        else if(val < root.val) return searchBST(root.left, val);
        else{
            return searchBST(root.right, val);
        }
    }
}