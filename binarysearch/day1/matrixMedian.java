/*
Brute: convert to 1D, sort, find mid
 */

class Solution {
    int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                list.add(mat[i][j]);
            }
        }
        
        Collections.sort(list);
        
        int idx = (n*m)/2;
        
        return list.get(idx);
    }
}

/*
optimal : to reduce time skip some elem which can be done using BS, if BS find search area, if x is median there should be numbr
 of smaller or equal > m*n/2, need to find the first occurence of condition, smaller or equal can be calculated using upper bound 
 becoz rows are sorted

 T.C -> log(10^9)(search area) * n- rows log(n) - upper bound
 S -> o(1)
 */

class Solution {
    int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
      int low = Integer.MAX_VALUE;
      int high = Integer.MIN_VALUE;
      
      for(int i = 0 ; i < n; i++){
          low = Math.min(low, mat[i][0]);
          high = Math.max(high, mat[i][n-1]);
      }
      
      while(low <= high){
          int mid = (low+high)/2;
          int req = (m*n)/2;
          int smallerEqual = countSmallerEqual(mid, mat);
          
          if(smallerEqual > req){
              high = mid -1;
          }else{
              low = mid + 1;
          }
      }
      
      return low;
    }
    
    int countSmallerEqual(int x, int mat[][]){
        int cnt = 0;
        for(int i = 0 ; i < mat.length; i++){
            int row[] = mat[i];
            cnt += upperBound(x, row);
        }
        
        return cnt;
    }
    
    int upperBound(int x, int a[]){
        int l = 0, h = a.length -1;
        int ans = a.length;
        
        while(l <= h){
            int mid = (l + h)/2;
            if(a[mid] > x){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return ans;
    }
}