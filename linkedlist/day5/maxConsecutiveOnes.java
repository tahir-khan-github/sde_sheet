/*
optimal: iterate and maintain cnt and max
T.C -> o(n);
S-> o(1)
 */
{
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int max = 0;

        for(int i = 0; i< n ; i++){
            if(nums[i] == 1){
                cnt++;
                max = Math.max(max, cnt);
            }else{
                cnt = 0;
            }
        }

        return max;
    }
}