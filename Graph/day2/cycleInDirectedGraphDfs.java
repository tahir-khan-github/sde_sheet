/*
Appraoch: basic dfs on graph , along with inRecursion coz in directed graph a vertex can visited from one dfs which will get detected in
        another dfs which is wrong to form a cycle a visited vertex detection should be in the same dfs
        ex: (0)->(1)<-(2) , here 0dfs will visit 1 but for 2 it should not be
 
 T.C -> (n+e)
 S -> (n+e)
 */

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
          for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean vis[] = new boolean[V];
        boolean inRecursion[] = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i] && dfs(adj, i, vis, inRecursion)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean dfs( ArrayList<ArrayList<Integer>> adj, int u, boolean vis[], boolean inRecursion[]){
        vis[u] = true;
        inRecursion[u] = true;
        
        for(int v: adj.get(u)){
            if(!vis[v] && dfs(adj, v, vis, inRecursion)){
                return true;
            }else if(inRecursion[v] == true){
                return true;
            }
        }
        
        inRecursion[u] = false;
        
        return false;
    }
}