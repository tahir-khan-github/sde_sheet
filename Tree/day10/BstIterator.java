/*
Brute: store inorder of bst which will be sorted then perform operation on array
T.C -> o(N)
S -> o(N)
 */


/*
oprimal: use stack and push all left child
        next -> st.pop go right and push all left child

T.C -> o(n)
S ->o(h)
 */
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
}