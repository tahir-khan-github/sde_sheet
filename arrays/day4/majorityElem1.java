//Majority element 1

/*
Brute:- using 2 loop
T.C -> (n^2)
*/
 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n ; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }
            if(cnt > n/2) return nums[i];
        }
        return -1;
    }
}

/*
better: becoz there is counting we can use freq/ hashing
T.C -> (NlogN) + (N)
S -> (N)
 */
{
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i],val + 1);
        }

        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            if(set.getValue() > n/2) return set.getKey();
        }

        return -1;
    }
}



/*
optimal:
1)Moore's voting algo to verify element 
2)verify element to be majority
 */

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int el = -1, cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(cnt == 0){
                el = nums[i];
                cnt = 1;
            }else if(nums[i] == el){
                cnt++;
            }else{
                cnt--;
            }
        }
        int cntEl = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == el){
                cntEl++;
            }
        }

        if(cntEl > n/2) return el;

        return -1;
    }
}