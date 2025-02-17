//Majority element 2 (n/3) - will always have only 2 majority elem

/*
brute: 2 iteration 1st is for elem and 2nd is for compare. compare only if elem in the ans is not equal to curr elem
T.C -> O(n^2)
S -> o(2) `= o(1)
 */
{
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(ans.size() == 0 || ans.get(ans.size() -1) != nums[i]){
                int cnt = 0;
                for(int j = 0 ; j < n ; j++){
                    if(nums[i] == nums[j]) cnt++;
                }
                if(cnt > n/3) ans.add(nums[i]);
            }
            if(ans.size() == 2) break;
        }

        return ans;
    }
}

/*
Better: using hashing
T.C -> O(nlogn) + o(n)
S-> o(2) + o(n) `= o(n)
 */
{
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i], val + 1);
        }
        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            if(set.getValue() > n/3) list.add(set.getKey());
        }

        return list;
    }
}

/*
Optimal : modify moore's voting with everything for 2 elem also add != condition of both count
T.C -> o(2n)
s -> o(n)
 */

{
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i], val + 1);
        }
        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            if(set.getValue() > n/3) list.add(set.getKey());
        }

        return list;
    }
}