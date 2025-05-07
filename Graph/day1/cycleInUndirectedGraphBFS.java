/*
Appraoch: bfs with queue pair to carry node and parent 
            loop on vertex to handle disconnected graphs
 */

class Pair{
    int node, parent;
    Pair(int node, int parent){
        this.node= node;
        this.parent = parent;
    }
}
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
             if(!vis[i] && bfs(adj, i, vis)){
                 return true;
             }
         }
         
         return false;
    }
    
    boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean []vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        vis[start] = true;
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            int u = temp.node;
            int parent = temp.parent;
        for(int v: adj.get(u)){
               if(!vis[v]){
                   vis[v] = true;
                   q.add(new Pair(v, u));
               }else if(v != parent){
                   return true;
               }
            }
        }
        
        return false;
        
        
    }
}