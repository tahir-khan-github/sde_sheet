/*
Appraoch: root = key return ceil = root
        if(key < root) ceil = root, ->left
        if(key > root) -> right
T.C ->o(h)
S ->o(1)
 */

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int ceil = - 1;
        
        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            
            if(key < root.data){
                ceil = root.data;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        
        return ceil;
    }
}
