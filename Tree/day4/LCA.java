/*
Brute: find root to node path and then compare both paths as soon as they mismatch return last matched
T.C -> o(n)
S-> o(n) + auxilary
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

         helper(root, list1, p.val);
         helper(root, list2, q.val);
        int i =0;
 
       while (i < list1.size() && i < list2.size()) {
            if (list1.get(i) != list2.get(i)) break;
            i++;
        }

        return  list1.get(i-1);
    }

    public boolean helper(TreeNode node, ArrayList<TreeNode> list, int t){
        if(node == null) return false;

        list.add(node);

        if(node.val == t) return true;

        boolean l = helper(node.left, list, t);
        boolean r = helper(node.right, list, t);

        if(l || r) return true;
        list.remove(list.size() -1);

        return false;
    }

}

/*
Optimal: modify above approach , by removing extra space, this can be done by below approach'
1)if left is null return right, if right null return left
2)if both null return null
3)if both left and right return some val then return current

T.C -> o(n)
S -> only auxilary
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        else{
            return root;
        }

    }
}