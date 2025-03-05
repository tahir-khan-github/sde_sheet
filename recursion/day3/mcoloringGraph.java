/*
Approach : recursion with isSafe
T.C -> v^m*edges
S -> o(n) + o(n)
 */

class Solution {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        if(solve(0,v, edges,new int[v], m) == true) return true;
        
        return false;
    }
    
    boolean solve(int node, int v, List<int[]> edges,int[] color ,int m){
        if(node == v){
            return true;
        }
        
        for(int i = 1 ; i <= m; i++){
            if(isValid(node,edges,color ,i)){
                color[node] = i;
                if(solve(node+1, v, edges, color, m) == true) return true;
                color[node] = 0;
            }
        }
        
        return false;
    }
    
boolean isValid(int node, List<int[]> edges, int[] color, int col) {
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];

        // If node is part of the edge, check its neighbor
        if (u == node && color[v] == col) return false;
        if (v == node && color[u] == col) return false;
    }
    
    return true;
}
}