/*
brute: using 2 loop
T.C -> (n^2)
 */
{
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];
        for(int i = 0 ; i <n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}

/*
better: using hashmap
T.C ->(nlogn)
S -> (n)
 */
 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i = 0 ; i <n ; i++){
            int moreNeeded = target - nums[i];
            if(map.containsKey(moreNeeded)){
                ans[0] = map.get(moreNeeded);
                ans[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }

        return ans;
    }
}

/*
If not asking indexes, sort the array, put low 0, high n-1, add and check if(more) reduce h--, if less increase l++
 */

