/*
Brute: using 3 loop
T.C -> o(n^3)
S-> o(ans)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1; j < n ; j++){
                for(int k = j +1; k < n; k++){
                    long sum = nums[i];
                     sum += nums[j] + nums[k];
                     if(sum == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                     }
                }
            }
        }

        return new ArrayList<>(set);
    }
}

/*
Better: using hashing
T.C -> (n^2) + log(ans)
S-> o(n) + o(ans)
 */
{
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            Set<Integer> hashSet = new HashSet<>();
            for(int j = i+1; j < n ; j++){
                    int sum = nums[i];
                    sum += nums[j];
                    int k = 0 - sum;
                     if(hashSet.contains(k)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(k);
                        Collections.sort(temp);
                        set.add(temp);
                     }
                     hashSet.add(nums[j]);

            }
        }

        return new ArrayList<>(set);
    }
}

/*
Optimal: sort array, fix i and use sliding window in j and k
T.C -> o(n^2) + o(nlogn);
S-> o(ans)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
            int sum = nums[i] + nums[j]+ nums[k];
            if(sum < 0){
                j++;
            }else if(sum > 0){
                k--;
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                ans.add(list);
                j++;
                k--;
                while(j< k && nums[j] == nums[j - 1]) j++;
                while(j< k && nums[k] == nums[k + 1]) k--;
            }
            }

        }

        return ans;
    }
}