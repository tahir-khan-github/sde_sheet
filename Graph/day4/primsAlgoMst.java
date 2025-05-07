/*
Approach: inorder to find minimum spanning tree i'l use min heap
        and to connect to vertives I need (wt, node) so this will be stored in min heap
T.C ->EVlog(v)
S-> S -> o(V + E)
 */

class Pair{
    int wt, node;
    Pair(int wt, int node){
        this.wt = wt;
        this.node = node;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.wt - y.wt);
        pq.add(new Pair(0,0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            int wt = temp.wt;
            int node = temp.node;
            
            if (vis[node]) continue;  // ✅ Skip if already visited
            vis[node] = true;
            sum += wt;

            for(int nbr[]: adj.get(node)){
                int nbrNode = nbr[0];
                int nbrWt = nbr[1];
                
                if(!vis[nbrNode]){
                    pq.add(new Pair(nbrWt, nbrNode));
                }
            }
        }
        
        return sum;
    }
}