/*
Brute: 1 loop to traverse till n-k+1, 2nd loop to scan max in k window
T.C -> (n-k+1) * k
S -> (n-k)
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];

        for(int i = 0 ; i < n - k + 1 ; i++){
            int maxi = nums[i];
            for(int j = i; j < i + k ; j++){
                maxi = Math.max(maxi, nums[j]);
            }
            ans[i] = maxi;
        }

        return ans;
    }
}

/*
optimal: Need a ds to maintain 3 window and a ds to maintain max(monotnic decrease stack) -> both things can be achived using dqueue
T.C -> 2n
S -> n-k;
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
          if(!dq.isEmpty() && dq.peek() == i-k){
            dq.poll();
          }

          while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
            dq.pollLast();
          }

          dq.offer(i);

          if(i >= k-1){
             ans[idx++] = nums[dq.peek()];
          }
        }

        return ans;
    }
}