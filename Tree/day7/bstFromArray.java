/*
Appraoch: find mid of the array
            make node from mid elem
            node.left -> start - mid -1
            node.right -> mid + 1, end

T.C ->o(n)
S-> o(n)
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }

    public TreeNode helper(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);

        return root;
    }
}