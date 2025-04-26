/*
Appraoch: find root from postorder
          find root idx from inorder,
          find left & right part from inorder (idx based)
T.c -> o(n)
S-> o(n)
 */

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = helper(inorder, 0, inorder.length - 1,postorder, 0, postorder.length - 1 ,map);

        return root;
    }

     public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder,int postStart, int postEnd ,HashMap<Integer, Integer> map){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIdxIn = map.get(root.val);
        int numLeft = rootIdxIn - inStart;

        root.left = helper(inorder, inStart, rootIdxIn - 1,postorder, postStart, postStart + numLeft - 1, map);
        root.right = helper(inorder,rootIdxIn + 1 , inEnd, postorder, postStart + numLeft, postEnd - 1 ,map);

        return root;
    }
}