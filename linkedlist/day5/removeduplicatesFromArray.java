/*
Brute: using hashset
T.C -> nlogn + n
S -> n
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        int idx = 0;
        for(int el: set){
            nums[idx] = el;
            idx++;
        }

        return idx;
    }
}

/*
Optimal: array is sorted so we can use 2 pointers
T.C -> o(n)
S -> o(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
     int i = 0;

     for(int j = 1; j < nums.length; j++){
        if(nums[i] != nums[j]){
            nums[i+1] = nums[j];
            i++;
        }
     }

     return i+1;
    }
}