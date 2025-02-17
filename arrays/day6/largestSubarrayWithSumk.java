/*
Brute: using loops
T.C -> o(n^2)
S -> o(1)
 */
 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
         for(int i = 0 ; i < n ; i++){
            set.add(nums[i]);
         }

        for(int el: set){
            if(!set.contains(el - 1)){
                int cnt = 1;
                int x = el;
                while(set.contains(x + 1)){
                    cnt++;
                    x = x + 1;
                }
            longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}

/*
Optimal: using prefix sum and hash(currSum - sum)
 */
{
    int maxLen(int arr[]) {
        int maxLen = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            currSum += arr[i];
            if(currSum == 0){ //subarry starts with 0 index
                maxLen = i+1;
            }
            if (map.containsKey(currSum - sum)) {
                maxLen = Math.max(maxLen, i - map.get(currSum - sum));
            } else {
                // Store the first occurrence of currSum
                map.put(currSum, i);
            }
        }
        
        return maxLen;
    }
}