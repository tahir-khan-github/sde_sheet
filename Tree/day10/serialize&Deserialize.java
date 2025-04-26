/*
Approach: serialize -> use level order to travel and store node to string , if null add as #
        deserialize -> use level order to attach child to praent
T.C- > o(n)
s  - > o(n)
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp == null){
                sb.append("#,");
                continue;
            }
            sb.append(temp.val+",");
        

            q.add(temp.left);
            q.add(temp.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String values[] = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1; i < values.length; i++){
            TreeNode temp = q.remove();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                temp.left = left;
                q.add(left);
            }

             if(!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                temp.right = right;
                q.add(right);
            }
        }

        return root;
    }
}
