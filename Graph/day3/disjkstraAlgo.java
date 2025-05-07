/*
Appraoch: Dijsktra uses priorityQueue min heap
        add source with 0 dist in pq
        pop min dist pair from pq
        go to its nbr and check if(dist + nbrdist < ans[nbrNode])
        ans[nbrNode] = dist + nbrdist and add to pq
 */


class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<Pair>());
        }        
      
       for(int edge[]: edges){
           int u = edge[0];
           int v = edge[1];
           int w = edge[2];
           adj.get(u).add(new Pair(v,w));
           adj.get(v).add(new Pair(u,w));
       }
       
       PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.first - y.first);
       
       int ans[] = new int[V];
       Arrays.fill(ans, Integer.MAX_VALUE);
       
       pq.add(new Pair(0, src));
       ans[src] = 0;
       
       while(!pq.isEmpty()){
           Pair temp = pq.remove();
           int node  = temp.second;
           int dist = temp.first;
           
           for(Pair nbr: adj.get(node)){
               int nbrNode  = nbr.first;
               int nbrDist = nbr.second;
               
               if(dist + nbrDist < ans[nbrNode]){
                   ans[nbrNode] = dist + nbrDist;
                   pq.add(new Pair(dist + nbrDist, nbrNode));
               }
           }
       }
       
       return ans;
    }
}