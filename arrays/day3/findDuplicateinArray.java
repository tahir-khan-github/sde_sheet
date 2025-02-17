//find duplicate in an array

/*
Brute:- sort the array then compare a[i] == a[i+1] , return a[i]
T.C -> o(NlogN) + O(N)
 */
{
    public int findDuplicate(int[] nums) {
        int ans = -1;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length -2 ; i++){
            if(nums[i] == nums[i+1]){
                ans = nums[i];
            }
        }

        return ans;
    }
}

/*
Better approach: - using frequency/ hashing as iterate make frequency array elem places to 1
                    if at aby point of time we found one already exist then break and return ans;
T.C -> O(n)
S -> O(n)                    
 */
{
    public int findDuplicate(int[] nums) {
        int ans = -1;
        int freq[] = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            if(freq[nums[i]] == 1){
                ans = nums[i];
                break;
            }else{
                freq[nums[i]] = 1;
            }
        }
        return ans;
    }
}

/*
Optimat approach:- floyd's fast and slow pointer
move fast by 2 and slow by 1 when they colide move fast to start and then start moving both by 1 when they again collide that will be the result
 T.C -> O(N) + O(N) `= O(N)
 */
{
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
            
            fast = nums[0];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        
    }
}