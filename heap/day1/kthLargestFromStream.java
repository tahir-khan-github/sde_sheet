/*
Brute: add all elems in arraylist, add new elem, and sort it and then return al.get(k)
T.C -> M(2n + logn)
S -> o(n)
 */



/*
optimal: add in pq and check for size() > k, if > k then pop elem from top
T.c -> o(mloh(k))
S -> o(k)
 */
class KthLargest {
    private int  K;
    private PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new  PriorityQueue<>();

        for(int num: nums){
            pq.add(num);
        }

        while(pq.size() > k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size() > K){
            pq.poll();
        }

        return pq.peek();
    }
}
