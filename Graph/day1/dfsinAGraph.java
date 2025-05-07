/*
Appraoch: tarverse on neghbors and check for visited
T.C -> o(n+e)
S -> (n)
 */
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Boolean> vis = new HashMap<>();
        
        dfsTraversal(adj, 0, vis, ans);
        
        return ans;
    }
    
    void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int u, HashMap<Integer,Boolean> vis, ArrayList<Integer> ans){
        vis.put(u, true);
        ans.add(u);
        for(int v: adj.get(u)){
            if(!vis.containsKey(v)){
                 dfsTraversal(adj, v, vis, ans);
            }
        }
    }
}