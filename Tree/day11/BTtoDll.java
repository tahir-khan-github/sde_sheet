/*
Approach: inorder traversal
        node.left = prev
        prev.right = node
T.C -> o(n)
S->o(h)
 */


class Solution {
     Node prev = null, head = null;
    Node bToDLL(Node root) {
       
        helper(root);
        return head;
    }
    
    void helper(Node root){
        if(root == null) return;
        
        helper(root.left);
        
        if(prev == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        
        prev = root;
        
        helper(root.right);
    }
}