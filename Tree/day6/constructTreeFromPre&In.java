/*
Appraoch: find root from preorder
          find root idx from inorder,
          find left & right part from inorder (idx based)
T.c -> o(n)
S-> o(n)
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,map);

        return root;
    }

    public TreeNode helper(int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdxIn = map.get(root.val);
        int numLeft = rootIdxIn - inStart;

        root.left = helper(preorder, preStart + 1, preStart + numLeft, inorder, inStart, rootIdxIn - 1, map);
        root.right = helper(preorder, preStart + numLeft + 1, preEnd, inorder,rootIdxIn + 1 , inEnd, map);

        return root;
    }
}