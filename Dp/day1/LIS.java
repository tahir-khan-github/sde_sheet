/*
Better: pick, nopick, prev, dp
T.C -> o(n*m), s-> o(n*m) + o(n)
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        return helper(0, -1, nums, dp);
    }

    int helper(int i, int prev, int[] arr, int [][]dp){
        if(i >= arr.length) return 0;

        if(dp[i][prev + 1] != -1) return dp[i][prev + 1];
        int take = 0, no_take = 0;
        if(prev == -1 || arr[prev] < arr[i]){
            take = 1 + helper(i+1, i, arr, dp);
        }

        no_take = helper(i+1, prev, arr, dp);

        return dp[i][prev  + 1] = Math.max(take, no_take);
    }
}

/*
More Better : tabulation:
            1)handle base case
            2)write changing params in opposite fashion
            3)copy recursion
T.C -> o(n*m), s-> o(n*m)
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        
       
        for(int i = n - 1; i>= 0; i--){
            for(int prev = i - 1; prev >= -1; prev--){
                 int take = 0;

                if(prev == -1 || nums[prev] < nums[i]){
                    take = 1 + dp[i+1][i+1];
                }

                int no_take = dp[i+1][prev + 1];

                 dp[i][prev  + 1] = Math.max(take, no_take);
            }
        }

        return dp[0][-1+1];
    }
}

/*
optimal: 1) convert 2d to 2 1d curr & next
            2) replace index + 1 with next and index with curr
            3)after each iteration mark next = curr
            4)retun curr
T.c -> o(n*m), S-> o(2n)
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
       
        int curr[] = new int[n+1];
        int next[] = new int[n+1];
        
       
        for(int i = n - 1; i>= 0; i--){
            for(int prev = i - 1; prev >= -1; prev--){
                 int take = 0;

                if(prev == -1 || nums[prev] < nums[i]){
                    take = 1 + next[i+1];
                }

                int no_take = next[prev + 1];

                 curr[prev  + 1] = Math.max(take, no_take);
            }
            next = curr;
        }

        return curr[0];
    }
}

/*
Printing Lis: trace back dp
 */

 ArrayList<Integer> list = new ArrayList<>();

           int i = 0, prev = -1;
           while(i < n){
             int take = 0;

                if(prev == -1 || nums[prev] < nums[i]){
                    take = 1 + dp[i+1][i+1];
                }

                int no_take = dp[i+1][prev + 1];
                if(take >= no_take){
                    list.add(nums[i]);
                    prev = i;
                }
                i++;
           }

         
           System.out.println(list);