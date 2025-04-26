/*
Appraoch: add left part excluding leaf, add leaf, add right in reverse excluding right
T.c -> o(n)
S-> o(n)
 */

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        ans.add(node.data);
        if(isLeaf(node)) return ans;
        
        addLeftNode(node.left, ans);
        addLeafNode(node, ans);
        addRightNode(node.right, ans);
        
        return ans;
    }
    
    Boolean isLeaf(Node node){
        if(node.left == null && node.right == null) return true;
        
        return false;
    }
    
    void addLeftNode(Node node, ArrayList<Integer> ans){
        if(node == null || isLeaf(node)) return;
        
        ans.add(node.data);
        if(node.left != null) addLeftNode(node.left, ans);
        else if(node.right != null) addLeftNode(node.right, ans);
    }
    
    void addLeafNode(Node node, ArrayList<Integer> ans){
        if(node == null) return;
        
        addLeafNode(node.left, ans);
        if(isLeaf(node)) ans.add(node.data);
        addLeafNode(node.right, ans);
    }
    
     void addRightNode(Node node, ArrayList<Integer> ans){
        if(node == null || isLeaf(node)) return;
        
        if(node.right != null) addRightNode(node.right, ans);
        else if(node.left != null) addRightNode(node.left, ans);
        ans.add(node.data);
    }
}