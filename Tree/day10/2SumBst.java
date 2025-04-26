/*
Brute: store inorder of bst, then use 2 pointer approach to find 2 sum
T.C -> o(2n)
s-> o(n)
 */

/*
Optimal: use bst iterator to get i and j value in 2 pointer approach
T.C -> o(n)
s-> o(h)
 */

class BstIterator{
    Stack<TreeNode> st;
    boolean isReverse;
    BstIterator(TreeNode root, boolean reverse){
        st = new Stack<>();
        isReverse = reverse;
        pushAll(root);
    }

    public void pushAll(TreeNode node){
        while(node != null){
            if(!isReverse){
                st.push(node);
                node = node.left;
            }else{
                st.push(node);
                node = node.right;
            }
        }
    }

    public int next(){
        TreeNode temp = st.pop();
        if(!isReverse){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }

        return temp.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BstIterator l = new BstIterator(root, false);
        BstIterator r = new BstIterator(root, true);
        int i = l .next();
        int j = r.next();
        
        while(i < j){
            if(i + j == k){
                return true;
            }

            if(i + j < k){
                i = l.next();
            }else{
                j = r.next();
            }
        }

        return false;
    }
}