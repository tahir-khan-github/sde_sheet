/*
Brute: Sort and return n-k
T.C -> o(nlogn)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
       int n = nums.length;
        Arrays.sort(nums);

        return nums[n-k];
    }
}

/*
Better: using priority queue
T.C -> o(nlogn)
S -> o(k)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
       int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n; i++){
            pq.add(nums[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}