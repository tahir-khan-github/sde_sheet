/*
Appraoch Level order line wise, (node, axis, level) , ds -> axis -> level -> node
 T.C -> n + nlogn
 S -> n
 */

class Tuple{
    TreeNode node;
    int axis;
    int level;
    Tuple(TreeNode node, int axis, int level){
        this.node = node;
        this.axis = axis;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null)return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple temp = q.remove();
            TreeNode node = temp. node;
            int axis = temp.axis;
            int level = temp.level;

            if(!map.containsKey(axis)){
                map.put(axis,new TreeMap<>());
            }
            if(!map.get(axis).containsKey(level)){
                map.get(axis).put(level, new ArrayList());
            }

            map.get(axis).get(level).add(node.val);

            if(node.left != null){
                q.add(new Tuple(node.left, axis-1, level + 1));
                
            }
            if(node.right != null){
                q.add(new Tuple(node.right, axis+1, level + 1));
            }
        }


        for(Map.Entry<Integer, TreeMap<Integer,ArrayList<Integer>>> axis: map.entrySet()){
            TreeMap<Integer,ArrayList<Integer>> levelMap= axis.getValue();
            ArrayList<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer,ArrayList<Integer>> level: levelMap.entrySet()){
                ArrayList<Integer> subList = level.getValue();
                Collections.sort(subList);
                list.addAll(subList);
            }

            ans.add(list);
        }

        return ans;
    }
}