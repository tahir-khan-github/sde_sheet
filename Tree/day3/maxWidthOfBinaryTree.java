/*
Approach: asking width at each level so level order traversal
if we mark each node with index then (right most index - left most idx) =  ans
edge case needs to be handled for node with incomplete children (2*i + 1)left, (2*i+2) right

T.C -> o(n)
S-> o(n)
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0L));
        long maxLen = 0;

        while(!q.isEmpty()){
            int size = q.size();
            long leftIdx = 0;
            long rightIdx = 0;

            for(int i = 0; i< size; i++){
                Pair temp = q.remove();
                TreeNode node = temp.node;
                long idx = temp.index;

                if(i == 0) leftIdx = idx;
                if(i == size - 1) rightIdx = idx;


                if(node.left != null){
                    q.add(new Pair(node.left, 2*idx + 1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, 2*idx +2));
                }
            }

            maxLen = Math.max(maxLen , rightIdx - leftIdx  + 1);
        }

        return (int)maxLen;
   