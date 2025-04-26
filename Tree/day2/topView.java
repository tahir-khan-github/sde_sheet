/*
Approach : level order line wise, ( use map and store only first occurence of line  so that 1st elem of each horizontal line can be stored)
T.C -> o(n)
S -> o(n)
 */
class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList <Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer, Integer> map= new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
       
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            Node node = temp.node;
            int hd = temp.hd;
            
           if(!map.containsKey(hd)){
                 map.put(hd, node.data);
           }
            
            if(node.left != null){
                q.add(new Pair(node.left, hd -1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, hd + 1));
            }
        }
        
        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            ans.add(set.getValue());
        }
        
        return ans;
    }
}