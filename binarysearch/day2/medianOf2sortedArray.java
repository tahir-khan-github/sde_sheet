/*
Brute: converto single sorted array, find median if n is even median = (n/2+n/2 -1)/2, else median = n /2\
T.C -> n+m
S-> n+m
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int arr[] = new int[n1+n2];
        int idx = 0;

        int l = 0, r = 0;
        while(l < n1 && r < n2){
            if(nums1[l] <= nums2[r]){
                arr[idx] = nums1[l];
                idx++;
                l++;
            }else{
                arr[idx] = nums2[r];
                idx++;
                r++;   
            }
        }

        while(l < n1){
            arr[idx] = nums1[l];
            idx++;
            l++;
        }

        while(r < n2){
            arr[idx] = nums2[r];
            idx++;
            r++;  
        }

        int n = n1 + n2;
        if(n%2 == 1) return arr[n/2];

        return (double)(arr[n/2]  + arr[n/2 - 1])/2;
    }
}

/*
Better: remove extra sace by just finding idx1, idx2, el1, el2 by using idx only
T.C -> n + m
S -> 1
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = (n1+n2);

        int idx = 0;
        int idx1 = (n/2) - 1;
        int idx2 = n/2;
        int el1 = -1;
        int el2 = -1;

        int l = 0, r = 0;
        while(l < n1 && r < n2){
            if(nums1[l] <= nums2[r]){
                if(idx == idx1) el1 = nums1[l];
                if(idx == idx2) el2 = nums1[l];
                idx++;
                l++;
            }else{
                if(idx == idx1) el1 = nums2[r];
                if(idx == idx2) el2 = nums2[r];
                idx++;
                r++;   
            }
        }

        while(l < n1){
            if(idx == idx1) el1 = nums1[l];
            if(idx == idx2) el2 = nums1[l];
            idx++;
            l++;
        }

        while(r < n2){
            if(idx == idx1) el1 = nums2[r];
            if(idx == idx2) el2 = nums2[r];
            idx++;
            r++;  
        }

        if(n%2 == 1) return el2;

        return (double)(el1 + el2)/2.0;
    }
}

/*
Optimal: binary search on semmetary partition , pick elem from left and right and validate l1< r2 && l2 < r1
if l1 > r2 picked more from a1 reduce a1 pick (high = mid-1), if (l2 > r1) picked more from a2 increase a1 pick(low = mid+1)
check for boundry mid2 = left - mid1
T.C -> log(min(n1,n2))
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = (n1+n2);
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int left = (n1+n2+1)/2;
        int low = 0 , high = n1;
      
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1-1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2-1 >= 0) l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if(n%2 == 1) return Math.max(l1,l2);

                return (double)(Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            }
            else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1 + 1;
            }
        }
    return 0;
    }
}