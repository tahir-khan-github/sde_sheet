/*
brute: find intersection(4 conditions) using loops
T.c -> o(n^2)
S->o(1)
 */
class Solution {

    static int findPlatform(int arr[], int dep[]) {
        int cnt = 0;
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            cnt = 1;
            for(int j = i+1; j<dep.length; j++){
                if ((arr[j] >= arr[i] && arr[j] <= dep[i]) ||   // Case 1: Train `j` starts during Train `i`
                    (dep[j] >= arr[i] && dep[j] <= dep[i]) ||   // Case 2: Train `j` ends during Train `i`
                    (arr[j] <= arr[i] && dep[j] >= dep[i]) ||   // Case 3: Train `j` fully covers Train `i`
                    (arr[j] >= arr[i] && dep[j] <= dep[i])) {
                    cnt++;
                    }
            }
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}

/*
optimal: As the time passes by
T.C -> o(2nlogn) + 2n;
S-> o(1)
 */
class Solution {

    static int findPlatform(int arr[], int dep[]) {
        int cnt = 0;
        int max = 0;
        int i = 0, j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while(i < arr.length){
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}
