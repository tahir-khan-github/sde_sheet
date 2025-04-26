/*
Brute: do a bfs and check for each node,  isValidBst  and then evaluate sum
T.c -> o(n^2)
s -> o(n)
 */

class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    void dfs(TreeNode root){
        if(root == null)return;

        if(isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            int sum = evaluateSum(root);
            maxSum = Math.max(maxSum, sum);
        }
        dfs(root.left);
        dfs(root.right);
    }

    boolean isValidBst(TreeNode root, int min, int max){
        if(root == null) return true;

        if(root.val < min || root.val >  max) return false;

        boolean l = isValidBst(root.left, min, root.val);
        boolean r = isValidBst(root.right, root.val, max);

        return l && r;
    }

    int evaluateSum(TreeNode root){
        if(root == null) return 0;
        return root.val + evaluateSum(root.left) + evaluateSum(root.right);
    }
}

/*
optimal: [maxSum, maxVal(largest on left), minVal(smallest from right)]
T.C -> o(n)
S-> o(h)
 */

class NodeVal{
    int maxSum, maxVal, minVal;
    NodeVal(int maxSum, int maxVal, int minVal){
        this.maxSum = maxSum;
        this.maxVal = maxVal;
        this.minVal = minVal;
    }
}
class Solution {
    public int maxSumBST(TreeNode root) {
        int ans[] = new int[1];
        helper(root, ans);
        return Math.max(ans[0],0);
    }

    public NodeVal helper(TreeNode root, int[] ans){
        if(root == null) return new NodeVal(0, Integer.MIN_VALUE, Integer.MAX_VALUE);

        NodeVal left = helper(root.left, ans);
        NodeVal right = helper(root.right, ans);

        if(left.maxVal < root.val && root.val < right.minVal){
            int currSum = root.val + left.maxSum + right.maxSum;
            ans[0] = Math.max(ans[0], currSum);
            return new NodeVal(currSum, Math.max(root.val, left.maxVal), Math.min(root.val,right.minVal));
        }

        return new  NodeVal(Math.max(left.maxSum, right.maxSum), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}