/*
Approach: 1 + max(lh,rh)
T.C -> o(n)
S -> o(h)
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }
}