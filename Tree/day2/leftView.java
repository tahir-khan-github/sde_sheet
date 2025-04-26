/*
Approach: dfs to travel, store left most at each level, level can be maintained by a ds.size()
T.C -> o(n)
S-> o(h)
 */
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        
        return list;
    }
    
    void helper(Node root, ArrayList<Integer> list, int level){
        if(root == null) return;
        
        if(list.size() == level){
            list.add(root.data);
        }
        helper(root.left, list, level+1);
        helper(root.right, list, level+1);
    }
}