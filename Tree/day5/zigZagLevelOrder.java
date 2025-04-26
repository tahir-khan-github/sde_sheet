/*
Appraoch: level order line wise, with flag to decide left to right and vise versa storgae, list.addLast (normal), list.addFirst(reverse)
T.c -> o(n)
S -> o(n)
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0 ; i < size; i++){
                TreeNode temp = q.remove();

                if (flag) {
                    level.addLast(temp.val);  // normal order
                } else {
                    level.addFirst(temp.val); // reversed order
                }

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            flag = !flag;
            ans.add(level);
        }

        return ans;
    }
}