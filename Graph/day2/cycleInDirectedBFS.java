/*
Approach: topo sort
          if size of topo sort is equal to V , then no cycle other wise cycle
          topo sort - all elems in linear manner 
        coz if cycle exist it will not be able to fill all elemes in topo sort
 */

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int indegree[] = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList());
        }
        
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        for(int u = 0 ; u < V ; u++){
            for(int v: adj.get(u)){
                indegree[v]++;
            }
        }
        
       
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < V; i++){
            if(indegree[i] == 0){
               q.add(i);
            }
        }
        
        bfs(adj, q, ans, indegree);
        
        if(ans.size() == V) return false;
        
        return true;
    }
    
     static void bfs(ArrayList<ArrayList<Integer>> adj,Queue<Integer> q, ArrayList<Integer> ans, int indegree[]){
       
       while(!q.isEmpty()){
           int u = q.remove();
           ans.add(u);
       
        for(int v: adj.get(u)){
            indegree[v]--;
            if(indegree[v] == 0){
               q.add(v);
            }
        }
       }
      
    }
}