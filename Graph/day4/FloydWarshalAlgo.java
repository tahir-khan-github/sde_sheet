/*
Approach: it says instead of firectly going frm node 0 to 1,  try going via each node like 0->2->1, o->3->1
            update which ever is min , mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j])
T.c -> o(n^3)
S -> o(n^2)
 */

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int m = dist[0].length;
         int INF = (int) 1e8;
 
        for(int via = 0 ; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0 ; j < m; j++){
                   if(dist[i][via] < INF && dist[via][j] < INF){
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                   }
                }
            }
        }
    }
}