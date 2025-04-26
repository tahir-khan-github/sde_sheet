/*
Approach: reverse inorder , with counter
T.C -> o(k)
S -> o(1)
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int ans[] = new int[1];
        int cnt[] = new int[1];
        reverseInorder(root, cnt, ans, k);
        return ans[0];
    }

    public void reverseInorder(TreeNode root, int []cnt,int []ans, int k){
        if(root == null) return ;

       reverseInorder(root.right, cnt, ans, k);
        cnt[0]++;

        if(cnt[0] == k){
            ans[0] = root.val;
            return;
        }

        reverseInorder(root.left, cnt, ans, k);
        
    }
}