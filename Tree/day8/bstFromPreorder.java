/*
Brute: create Manually, using insert
T.C -> o(n^2)
S -> o(1)
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insertBst(root, preorder[i]);
        }

        return root;
    }

    public TreeNode insertBst(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(val < root.val){
           root.left = insertBst(root.left, val);
        }else{
            root.right = insertBst(root.right, val);
        }

        return root;
    }
}

/*
optimal: [-min, node], [node, max]
T.C -> o(n)
S -> o(1)
 */
class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public TreeNode helper(int []arr, long min, long max){
        if(idx == arr.length) return null;
        else if(arr[idx] >= min && arr[idx] < max){
            TreeNode node = new TreeNode(arr[idx]);
            idx++;
            node.left = helper(arr, min, node.val);
            node.right = helper(arr, node.val, max);

            return node;
        }else{
            return null;
        }
    }
}