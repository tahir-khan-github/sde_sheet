//Given an integer array nums, find the subarray with the largest sum

/**
  optimal

T.c `= n
  */

 class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi =  Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];

            if(sum > maxi){
                maxi = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }


        return maxi;
    }
}

//follow up to pirnt sub array with max sum
 {
      public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");
      }
 }