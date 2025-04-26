/*
Approach: there are 3 possibilities of path
1)both left and right is good -> l + r + root.val
2)ek achcha hai -> max(l, r) + root.val
3)dono kharab -> root.val,

ans = max(1, 2, 3);(max possible paths)
return max(2, 3)
 we can't return 1 because its not b/w 2 nodes, and its a converge path

 T.c-> o(n)
 S-> o(h)
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;   
        helper(root, maxi);

        return maxi[0];
    }

    public int helper(TreeNode node, int[] maxi){
        if(node == null) return 0;

        int l = helper(node.left, maxi);
        int r = helper(node.right, maxi);

        int dono_achche = l + r + node.val;

        int ek_achcha = Math.max(l, r) + node.val;

        int dono_kharab = node.val;

        maxi[0] = Math.max(maxi[0], Math.max(dono_achche, Math.max(ek_achcha, dono_kharab)));

        return Math.max(ek_achcha, dono_kharab);
    }
}