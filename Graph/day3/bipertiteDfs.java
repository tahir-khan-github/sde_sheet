/*
Approach: color of adj vertex should always be different than parent
T.C -> o(n+e)
S -> o(n) + o(n)
 */

class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int color[] = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1 && dfs(adj, i, color, 1) == false){
                return false;
            }
        }
        
        return true;
    }
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int u,  int color[],int ucolor){
        color[u] = ucolor;
        
        for(int v: adj.get(u)){
            if(color[v] == color[u]){
                return false;
            }
            else if(color[v] == -1){
               int  colorOfV = 1 - ucolor;
                if(dfs(adj,v,color, colorOfV) == false) return false;
            }
            
           
        }
        
        return true;
    }
}