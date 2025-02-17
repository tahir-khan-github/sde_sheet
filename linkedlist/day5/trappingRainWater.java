/*
Brute: water store = min(lmax - rmax) - arr[i];
T.C -> 3n
S -> 2n
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int[] lmax = prefixSum(height);
        int[] rmax = suffixSum(height);

        for(int i = 0 ; i < n ; i++){
            total += Math.min(lmax[i], rmax[i]) - height[i];
        }

        return total;
    }

    public int[] prefixSum(int[] arr){
        int n = arr.length;
        int []lmax = new int[n];

        lmax[0] = arr[0];

        for(int i = 1; i<n; i++){
            if(arr[i] > lmax[i-1]){
                lmax[i] = arr[i];
            }else{
                lmax[i] = lmax[i-1];
            }
        }

        return lmax;
    }

     public int[] suffixSum(int[] arr){
        int n = arr.length;
        int []rmax = new int[n];

        rmax[n-1] = arr[n-1];

        for(int i =n-2; i>=0; i--){
            if(arr[i] > rmax[i+1]){
                rmax[i] = arr[i];
            }else{
                rmax[i] = rmax[i+1];
            }
        }

        return rmax;
    }
}

/*
Better: lmax can be calculated while applyng formula
T.C -> 2n
s -> n
 */
 {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int lmax = height[0];
        int[] rmax = suffixSum(height);

        for(int i = 1 ; i < n ; i++){
            lmax = Math.max(lmax, height[i]);

            total += Math.min(lmax, rmax[i]) - height[i];
        }

        return total;
    }


     public int[] suffixSum(int[] arr){
        int n = arr.length;
        int []rmax = new int[n];

        rmax[n-1] = arr[n-1];

        for(int i =n-2; i>=0; i--){
            if(arr[i] > rmax[i+1]){
                rmax[i] = arr[i];
            }else{
                rmax[i] = rmax[i+1];
            }
        }

        return rmax;
    }
}

/*
Optimal: two pointer approach
T.C -> o(n)
S->o(1)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax = 0, rmax = 0, total = 0, l = 0, r = n -1;
        
        while(l < r){
            if(height[l] <= height[r]){
                if(lmax > height[l]){
                    total += lmax - height[l];
                }else{
                    lmax = height[l];
                }
                l++;
            }else{
                if(rmax > height[r]){
                    total += rmax - height[r];
                }else{
                    rmax = height[r];
                }
                r--;
            }
        }

        return total;
    }
}