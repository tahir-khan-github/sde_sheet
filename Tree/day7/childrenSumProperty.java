/*
Appraoch: while going down maintain children and root so that we don't have to reduce node
            while going up maintain children sum property
T.C -> o(n)
S-> o(h)
 */

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root == null) return;

        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;

        if(child >= root.data) root.data = child;
        else{
             if(root.left != null) root.left.data = root.data;
             if(root.right != null) root.right.data= root.data;
        }

        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total += root.right.data;

        if(root.left != null || root.right != null) root.data = total;
    }
}