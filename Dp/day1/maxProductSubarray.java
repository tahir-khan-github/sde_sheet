/*
Optimal : observation
`           1)if all +ve - +ve
            2)if even -ve -> +ve
            3)if odd -ve -> removal of 1 -ve and ans lies in prefix or suffix
            4)if contians 0, then pick new subarray by making prefix = 1 and suffix = 1
T.C -> o(n)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];

            maxi = Math.max(maxi, Math.max(prefix, suffix));    
        }
        

        return maxi;
    }
}