/*
Appraoch: recursion in 4 direction with visited matrix to prevent same visit, also boundry
T.C -> 4^(n*m)
S-> o(n*m)
 */

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();
        int m = mat.get(0).size();
        int a[][] = new int[n][m];
        int vis[][] = new int[n][m];
        
        for(int  i = 0 ; i < n; i++){
            for(int j = 0 ; j<m; j++){
                a[i][j] = mat.get(i).get(j);
            }
        }
        
        if(a[0][0] == 1){
            solve(0,0,a, vis,"", ans, n,m);
            return ans;
        }
        
        return ans;
    }
    
    public void solve(int i, int j, int a[][],int vis[][], String s, ArrayList<String> ans, int n, int m){
        if(i == n-1 && j == m-1){
            ans.add(s);
            return;
        }
        
        //Down
        if(i+1 < n && vis[i+1][j] == 0 && a[i+1][j] == 1){
            vis[i][j] = 1;
            solve(i+1, j, a, vis, s + "D", ans, n, m);
            vis[i][j] = 0;
        }
        
        //left
        if(j-1 >0 && vis[i][j-1] == 0 && a[i][j-1] == 1){
            vis[i][j] = 1;
            solve(i, j-1, a, vis, s + "L", ans, n, m);
            vis[i][j] = 0;
        }
        
        //right
        if(j+1 < m && vis[i][j+1] == 0 && a[i][j+1] == 1){
            vis[i][j] = 1;
            solve(i, j+1, a, vis, s + "R", ans, n, m);
            vis[i][j] = 0;
        }
        
        //up
        if(i-1 >0 && vis[i-1][j] == 0 && a[i-1][j] == 1){
            vis[i][j] = 1;
            solve(i-1, j, a, vis, s + "U", ans, n, m);
            vis[i][j] = 0;
        }
    }
}



/*
shorter version
 */
class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();
        int m = mat.get(0).size();
        int a[][] = new int[n][m];
        int vis[][] = new int[n][m];
        int dirs[][] = {{1,0},{0,-1},{0,1},{-1, 0}};
        
        for(int  i = 0 ; i < n; i++){
            for(int j = 0 ; j<m; j++){
                a[i][j] = mat.get(i).get(j);
            }
        }
        
        if(a[0][0] == 1){
            solve(0,0,a, vis,"", ans, n,m, dirs);
            return ans;
        }
        
        return ans;
    }
    
    public void solve(int i, int j, int a[][],int vis[][], String s, ArrayList<String> ans, int n, int m, int dirs[][]){
        if(i == n-1 && j == m-1){
            ans.add(s);
            return;
        }
        
        String ch = "DLRU";
        
        for(int k = 0 ; k < 4 ; k++){
            int []dir = dirs[k];
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && vis[nexti][nextj] == 0 && a[nexti][nextj] == 1){
                vis[i][j] = 1;
                solve(nexti, nextj, a, vis, s + ch.charAt(k), ans, n, m, dirs);
                vis[i][j] = 0;
            }
        }
    }
}