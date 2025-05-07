/*
Appraoch: basic dfs with parent variable
            also loop for each vertex inorder to handle sepreate vertex

T.C -> o(n  +e)
s ->o(n)
 */

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean vis[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
         for(int i = 0 ; i < V; i++){
             if(!vis[i] && dfs(adj, i, vis, -1)){
                 return true;
             }
         }
         
         return false;
    }
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean []vis, int parent){
        vis[u] = true;
        
        for(int v: adj.get(u)){
            if(v == parent) continue;
            
            if(vis[v]) return true;
            
            if(dfs(adj,v,vis, u)) return true;
        }
        
        return false;
        
        
    }
}