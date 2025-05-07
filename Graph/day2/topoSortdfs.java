/*
Approach: topo sort tells u will come first before V
            basic dfs with stack to store order of topo sort
            to maintain order we store vertex in stack while back tracking
T.C -> o(n + e)
T.C -> o(n + e)
 */

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList());
        }
        
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < V; i++){
            if(!vis[i]){
                dfs(adj, i, vis , st);
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            ans.add(st.pop());
        }
        
        
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean vis[], Stack<Integer> st){
        vis[u] = true;
        
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfs(adj, v, vis, st);
            }
        }
        
        st.push(u);
    }
}