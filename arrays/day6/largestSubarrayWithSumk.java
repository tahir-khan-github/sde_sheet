/*
Brute: using loops
T.C -> o(n^2)
S -> o(1)
 */
 {
    public int longestConsecutive(int[] nums) {
         int maxLen = 0;
        for(int i = 0 ;  i< nums.length; i++){
            int sum = 0;
            for(int j  = i ; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }    

        return maxLen;
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