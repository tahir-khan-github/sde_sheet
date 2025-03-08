/*
Approach: Bs can be implemented on sorted array, so we need to find which part is sorted left/right, then need to check the sorted part
contains target if yes then eliminate other part else eleminate itself
T.C -> logn
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] == target) return mid;

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }

        return -1;
    }
}