/*
Approach: sort all edges in ascending order w.r.t to wt
          if (u & v) are not connected  which can be find by u_parent != v_parent ,
           then connect (union(u_parent, v_parent)) and take sum
T.C ->  
S ->
 */

class Pair{
    int u, v, wt;
    Pair(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}
// User function Template for Java

class Solution {
    static int parent[];
    static int rank[];

    static int kruskalsMST(int V, int[][] edges) {
        parent = new int[V];
        rank = new int[V];
        
         for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        List<Pair> edgeList = new ArrayList<>();
        
        for (int[] edge : edges) { //V + E
            edgeList.add(new Pair(edge[0], edge[1], edge[2]));
        }
        
        edgeList.sort((a, b) -> a.wt - b.wt); //Elog(E)
        
        
        return kruskals(edgeList);
    }
    
   static int kruskals(List<Pair> edgeList){
        int sum = 0;
        
        for(Pair nbr: edgeList){ //E * (4*alpha)
            int u = nbr.u;
            int v = nbr.v;
            int wt = nbr.wt;
            
            int u_parent = find(u);
            int v_parent = find(v);
            if(u_parent != v_parent){
                union(u_parent, v_parent);
                sum += wt;
            }
        }
        
        return sum;
    }
    
    static int find(int i){
        if(i == parent[i]) return i;
        
        return parent[i] = find(parent[i]);
    }
    
    static void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);
        
        if(x_parent == y_parent) return;
        
        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[x_parent] < rank[y_parent]){
             parent[x_parent] = y_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent] += 1;
        }
    }
}
