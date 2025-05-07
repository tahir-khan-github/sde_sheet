/*
Appraoch: 1) find topo sort
            2)reverse all edges
               3)apply dfs to count
T.c -> o(v + e)
s -> o(v + e)
 */

class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < V; i++){
            if(!vis[i]){
                dfsFillTopoSort(adj, i, vis, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjReverse.add(new ArrayList<>());
        }

        for(int u = 0 ; u < V; u++){
            for(int v: adj.get(u)){
                adjReverse.get(v).add(u);
            }
        }
        
        Arrays.fill(vis, false);
        int cnt = 0;
        
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                dfs(adjReverse, node, vis);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    void dfsFillTopoSort(ArrayList<ArrayList<Integer>> adj, int u,  boolean vis[], Stack<Integer> st){
        vis[u] = true;
        
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfsFillTopoSort(adj,v,vis,st);
            }
        }
        st.push(u);
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj, int u,  boolean vis[]){
        vis[u] = true;
        
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfs(adj, v, vis);
            }
        }
    }
}