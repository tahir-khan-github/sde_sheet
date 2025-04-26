/*
Brute: use height to compute at each node and then evaluate dia at each node
T.C -> o(n^2)
S-> o(h)
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int dia){
        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        dia = Math.max(dia, lh + rh);

        helper(node.left,dia);
        helper(node.right,dia);

        return dia;
    }

    public int height(TreeNode node){
        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        return 1 + Math.max(lh, rh);
    }
}

/*
Optimal: Use height formula to compute dia 
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int dia[] = new int[1];
         helper(root, dia);
         return dia[0];
    }

    public int helper(TreeNode node, int[] dia){
        if(node == null) return 0;

        int lh = helper(node.left, dia);
        int rh = helper(node.right, dia);

        dia[0] = Math.max(dia[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}