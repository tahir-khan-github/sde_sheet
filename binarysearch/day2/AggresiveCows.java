/*
Brute: asking for min distance b/w 2 stalls , min can possible b/w 2 consecutive so we sort. As its asking for min dist we can start from 1
and can go upto maxdist = a[n-1] - a[0], need to check distPlacement if(a[i] - last >= distPlacement) we can place cow and cntCow++
if cntCow >= cows means we can check for next distPlacement
T.c -> nlogn + (maxDist *n)
S -> 1
 */
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        
        int high = stalls[n-1] - stalls[0];
        
        for(int distPlacement = 1; distPlacement <= high; distPlacement++){
            int cntCows = helper(stalls, distPlacement);
            if(cntCows >= k) continue;
            else{
                return distPlacement - 1;
            }
        }
        
        return 0;
    }
    
    public static int helper(int[] stalls, int distPlacement) {
        int cntCows = 1, last = stalls[0];
        
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= distPlacement){
                cntCows++;
                last = stalls[i];
            }
        }
        
        return cntCows;
    }
}

/*
optimal: ls x-> Bs, (min)max -> BS, search area[1 to maxDist] we do BS on distPlacement
T.C ->nlogn + (log(maxDist) *n)
 */

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        int ans = -1;
        
       while(low <= high){
           int mid = (low+high)/2;
            int cntCows = helper(stalls, mid);
            if(cntCows >= k){
                low = mid + 1;
                ans = mid;
            }
            else{
               high = mid - 1;
            }
        }
        
        return ans;
    }
    
    public static int helper(int[] stalls, int distPlacement) {
        int cntCows = 1, last = stalls[0];
        
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= distPlacement){
                cntCows++;
                last = stalls[i];
            }
        }
        
        return cntCows;
    }
}