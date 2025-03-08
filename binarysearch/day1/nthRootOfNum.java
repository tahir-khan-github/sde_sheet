/*
Approach: find monotonic patter and find search area
T.C -> log2m * n
S -> o(1)
 */
public class Solution {
    public static int NthRoot(int n, int m) {
        int low = 1, high = m;

        while(low <= high){
            int mid = (low + high)/2;
            int midN = multiply(mid, m, n);

            if(midN == 1){
                return mid;
            }else if(midN == 2){
                high = mid - 1;
            }else{
                low = mid  + 1;
            }
        }

        return -1;
    }

    public  static int multiply(int mid, int m, int n){
        long ans = 1;
        for(int i = 1; i <= n; i++){
            ans *= mid;
            if(ans > m) return 2;
        }

        if(ans == m) return 1;

        else return 0;

    }
}
