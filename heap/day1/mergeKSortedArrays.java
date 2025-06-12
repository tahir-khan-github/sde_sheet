/*
Brute: add all the elems in ans and then sort the ans
T.C -> (n*m) + (n*m)log(n*m)
S -> o(n*m)
 */

/*
optimal: process all three arrays at the same time using priority Queue
T.c -> (n*m)log(m)
S -> o(n*m) + log(m)
 */

class Triplet{
    int data, i, j;
    Triplet(int data, int i, int j){
        this.data = data;
        this.i = i;
        this.j = j;
    }
}
class Solution {
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int n = K;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i <n; i++){
            pq.add(new Triplet(arr[i][0], i, 0));
        }
        
        while(!pq.isEmpty()){
            Triplet temp = pq.poll();
            ans.add(temp.data);
            int i = temp.i;
            int j = temp.j;
            
            if(j+1 < arr[i].length){
                pq.add(new Triplet(arr[i][j+1], i, j+1));
            }
        }
        
        return ans;
    }
}