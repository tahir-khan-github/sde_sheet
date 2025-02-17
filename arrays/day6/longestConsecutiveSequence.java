/*
Brute: using loops
T.C -> o(n^2) near about
S -> o(1)
 */
{
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 1;

        for(int i = 0 ; i < n ; i++){
            int x = nums[i];
            int cnt = 1;
            while(linearSearch(nums, x+1) == true){
                x = x + 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    public boolean linearSearch(int []arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return true;
        }
        return false;
    }
}

/*
Better: sort and maintain lastSmaller and avoid duplicate
T.C -> 0(nlogn) + o(n)
S -> o(1)
 */

 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        Arrays.sort(nums);

        for(int i = 0 ; i < n ; i++){
            
            if(nums[i] - 1 == lastSmaller){
                cnt++;
                lastSmaller = nums[i];
            }else if(nums[i] == lastSmaller){
                continue;
            }
            else{
                cnt = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}

/*
Optimal: add all elem in set and check for start of sequence and iterate from there to count sequence
T.C -> o(n) + o(n+n) `= o(3n)
S-> o(n);
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