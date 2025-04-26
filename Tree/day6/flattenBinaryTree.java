/*
Appraoch: right needs to be traverse first, then left will be traverse , 
            prev to carry to make connection
            all node will be connected to right
            all node left will be null
T.C -> o(n)
S-> o(n)
 */

TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}