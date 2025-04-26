/*
Appraoch: if root val < both - go right
            if root val > both - go left
T.C -> o(h)
S -> o(1)
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val > p.val && root.val > q.val){
           return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val){
           return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}