/*
Brute: check for left right if not equal elem is single
 T.C -> o(n)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            if(i == 0){
                if(nums[i] != nums[i+1]) return nums[i];
            }else if( i == n-1){
                 if(nums[i] != nums[i-1]) return nums[i];
            }else{
                 if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) return nums[i];
            }
        }

        return -1;
    }
}

/*
optimal: array is sorted and we need to find so we can think of BS
search area will []
elemination -> (even, odd) -> elem on right part
elemination -> (odd, even) -> elem on left part
matching -> elem(a[mid]) left and right not same
T.C -> o(logn)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n-2;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            else if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])) low = mid + 1;
            else high = mid -1;
        }

        return -1;
    }
}