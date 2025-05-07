/*
Appraoch: bfs(adj, q, vis, ans)
          add to q
          vis the node
          add to ans
T.C -. o(n+e)
S -> o(n)
 */


class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
         ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Boolean> vis = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        bfsTraversal(adj, q, vis, ans);
        
        return ans;
    }
    
     void bfsTraversal(ArrayList<ArrayList<Integer>> adj, Queue<Integer> q, HashMap<Integer,Boolean> vis, ArrayList<Integer> ans){
        q.add(0);
        vis.put(0, true);
        ans.add(0);
        
        while(!q.isEmpty()){
        int u = q.remove();

        for(int v: adj.get(u)){
            if(!vis.containsKey(v)){
                q.add(v);
                vis.put(v, true);
                ans.add(v);
            }
        }
          
        }
    }
}