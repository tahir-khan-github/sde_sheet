/*
Brute: observe in question, need to pick maximum number of pages a student can hold, then devide books in students if devide not possible
increase maxPageHold, low(start) maxPage, high(end) sum of all pages, linear search
T.C -> o(sum-max+1)*n
 */

public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        
        if(B > A.size()){
            return -1;
        }
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(Integer pages: A){
            low = Math.max(low,pages);
            high += pages;
        }
        
        for(int maxPageHold = low; maxPageHold <= high; maxPageHold++){
            int cntStd = helper(A, maxPageHold);
            if(cntStd == B) return maxPageHold;
        }
        
        return 0;
    }
    
    public int helper(ArrayList<Integer> A, int maxPageHold){
        int std = 1, stdPageHold = 0;
        for(Integer pages: A){
            if(stdPageHold + pages <= maxPageHold){
                stdPageHold += pages;
            }else{
                std++;
                stdPageHold = pages;
            }
        }
        
        return std;
    }
}

/*
Optimal: linear search -> BS, search area (low, high), mid = maxPageHold, we can reduce maxPageHold iteration by BS
T.C -> log(sum-max+1)*n
 */
public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        
        if(B > A.size()){
            return -1;
        }
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(Integer pages: A){
            low = Math.max(low,pages);
            high += pages;
        }
        
        while(low <= high){
            int mid = (low+high)/2;
            int cntStd = helper(A, mid);
            if(cntStd > B){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    public int helper(ArrayList<Integer> A, int maxPageHold){
        int std = 1, stdPageHold = 0;
        for(Integer pages: A){
            if(stdPageHold + pages <= maxPageHold){
                stdPageHold += pages;
            }else{
                std++;
                stdPageHold = pages;
            }
        }
        
        return std;
    }
}
