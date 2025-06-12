/*
Brute: find all combination, sort the combination list and return  first k elems
T.C -> (n^2 + 2logn + k)
S -> o(n^2)
 */

/*
optimal approach: sort both arrays, make first largest from [n-1][n-1], use priority queue to avoid sorting
checl for diagonal combination
T.C ->   nlogn + k
S => o(k) + o(n^2)
 */
// User function Template for Java
class Tuple{
    int sum,x, y;
    Tuple(int sum,int x, int y){
        this.sum = sum;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        int n = A.length;
        int k = K;
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        boolean vis[][] = new boolean[n][n];
        
        pq.add(new Tuple(A[n-1] + B[n-1], n-1, n-1));
        vis[n-1][n-1] = true;
        
        while(k > 0){
            Tuple temp = pq.poll();
            ans.add(temp.sum);
            
            int x = temp.x;
            int y = temp.y;
            
            if(x-1 >= 0 && !vis[x-1][y]){
                pq.add(new Tuple(A[x-1]+ B[y], x-1, y));
                vis[x-1][y] = true;
            }
            
            if(y-1 >= 0 && !vis[x][y-1]){
                pq.add(new Tuple(A[x]+ B[y-1], x, y-1));
                vis[x][y-1] = true;
            }
            k--;
        }
        
        return ans;
    }
}