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

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int el1 = 0, el2 =0, cnt1=0, cnt2=0;

        for(int i = 0 ; i < n ; i++){
           if(cnt1 == 0 && el2 != nums[i]){
            el1 = nums[i];
            cnt1 = 1;
           }else if(cnt2 == 0 && el1 != nums[i]){
            el2 = nums[i];
            cnt2 = 1;
           }else if(el1 == nums[i]){
            cnt1++;
           }else if(el2 == nums[i]){
            cnt2++;
           }else{
            cnt1--;
            cnt2--;
           }
        }
        int elCnt1 = 0, elCnt2 = 0;
        for(int i= 0; i< n; i++){
            if(el1 == nums[i]) elCnt1++;
            if(el2 == nums[i]) elCnt2++;
        }
        if(elCnt1 > n/3) list.add(el1); 
        if(elCnt2 > n/3) list.add(el2); 

        return list;
    }
}