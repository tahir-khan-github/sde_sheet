//Given an array of integers nums, find the next permutation of nums.
// array of n integer can have n! permutation [3,1,2] can have 6 permutation i.e 3! = 6
//inorder to find next permutation all permutation should be in a sorted order

/*
Brute force
-> generate all permutation using recursion
-> do a linera search to find given integer array
-> return next index if present else return 1st

T.C -> (N! * N) + N which is huge
N!*N because we know it takes N! permutation and each time N elements will be genarted
 */

/*
Optimal
Observation -> Algo -> dryrun -> code
->find longest prefix with a dip
->swap with smallest among all
->reverse remaining as they are sorted now
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        //finding break point
        for(int i = n-2; i>= 0 ; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(nums, 0, n-1);
            return;
        }

        //swap with just greater
         for(int i = n-1; i>= 0 ; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
         }

        reverse(nums, index+1, n-1);

    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
        }
    }
}