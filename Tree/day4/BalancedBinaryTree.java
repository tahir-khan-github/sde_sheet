/*
Brute: evaluate left and right height at each node then check for balanced
T.C -> o(n^2)
S -> o(n)
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }

       public boolean helper(TreeNode node){
        if(node == null) return true;

        int lh = height(node.left);
        int rh = height(node.right);

        if(Math.abs(lh - rh) > 1) return false;

        boolean left = helper(node.left);
        boolean right = helper(node.right);

        if(!left || !right) return false;

        return true;
    }

     public int height(TreeNode node){
        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        return 1 + Math.max(lh, rh);
    }
}

/*
Optimal: evaluate while computing height
T.c -> o(n)
S -> o(h)
 */


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(height(root) == -1) return false;

        return true;
    }

     public int height(TreeNode node){
        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        if(lh == -1 || rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}