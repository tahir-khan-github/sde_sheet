/*
Recursion: take, no_take, with next job
 */

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int arr[][] = new int[n][3];
        for(int i = 0 ; i < n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

         Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
         });

        return helper(0, arr);
    }

    int helper(int i, int [][]arr){
        if(i >= arr.length) return 0;

        int nextJob = getNextJob(i+1, arr[i][1], arr);
      
        int take = arr[i][2] + helper(nextJob, arr);
        int no_take = 0 + helper(i+1, arr);

        return Math.max(take, no_take);
    }

    int getNextJob(int l, int currEndJob, int [][]arr){
        int r = arr.length -1;

        int result = arr.length;
        while(l <= r){
            int mid = (l + r)/2;

            if(arr[mid][0] >= currEndJob){
                result = mid;
                r = mid -1;
            }else{
                l = mid+1;
            }
        }

        return result;
    }
}

/*
memoize:
T.C - o(n) * logn + nlogn
S -> o(n) + o(n) 
 */
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int arr[][] = new int[n][3];
        for(int i = 0 ; i < n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

         Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
         });

        int memo[] = new int[arr.length];
        Arrays.fill(memo, -1);

        return helper(0, arr, memo);
    }

    int helper(int i, int [][]arr, int memo[]){
        if(i >= arr.length) return 0;

        if(memo[i] != -1) return memo[i];

        int nextJob = getNextJob(i+1, arr[i][1], arr);
      
        int take = arr[i][2] + helper(nextJob, arr, memo);
        int no_take = 0 + helper(i+1, arr, memo);

        return memo[i] = Math.max(take, no_take);
    }

    int getNextJob(int l, int currEndJob, int [][]arr){
        int r = arr.length -1;

        int result = arr.length;
        while(l <= r){
            int mid = (l + r)/2;

            if(arr[mid][0] >= currEndJob){
                result = mid;
                r = mid -1;
            }else{
                l = mid+1;
            }
        }

        return result;
    }
}

/*
Tabulation:
T.C - o(n) * logn + nlogn
S -> o(n)
 */

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int arr[][] = new int[n][3];
        for(int i = 0 ; i < n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

         Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
         });

        int memo[] = new int[arr.length + 1];

        memo[n] = 0;

        for(int i = n -1; i>= 0; i--){
            int nextJob = getNextJob(i+1, arr[i][1], arr);
      
            int take = arr[i][2] + memo[nextJob];
            int no_take = 0 + memo[i+1];

            memo[i] = Math.max(take, no_take);
        }

        return memo[0];
    }


    int getNextJob(int l, int currEndJob, int [][]arr){
        int r = arr.length -1;

        int result = arr.length;
        while(l <= r){
            int mid = (l + r)/2;

            if(arr[mid][0] >= currEndJob){
                result = mid;
                r = mid -1;
            }else{
                l = mid+1;
            }
        }

        return result;
    }
}