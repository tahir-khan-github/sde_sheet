//merge 2 sorted arrays 

/*
Brute:-
add sorted elements of arr1 and arr2 into arr3 using 2 pointers
then put all element of arr3 into arr1 and arr2 respectively 
T.C -> (m+n) + (m+n)
S -> (m+n)
 */
{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=0, p2=0, idx=0;
        int []arr = new int[m+n];

        while(p1 < m && p2 < n){
            if(nums1[p1] <= nums2[p2]){
                arr[idx] = nums1[p1];
                idx++;
                p1++;
            }else{
                arr[idx] = nums2[p2];
                idx++;
                p2++;               
            }
        }

        while(p1 < m){
             arr[idx] = nums1[p1];
             idx++;
             p1++;
        }

        while(p2 < n){
            arr[idx] = nums2[p2];
            idx++;
            p2++; 
        }

        for(int i = 0 ; i < arr.length; i++){
            if(i < m){
                nums1[i] = arr[i];
            }else{
                nums2[i-m] = arr[i];
            }
        }
    }
} 

/*
as they are sorted the last elem of arr1 should be greates and the first elem of arr2 should be smaller
and we compare if arr1[p1] > arr2[p2] them we swap till this satisfies else we break and then we sort the arr1 and arr2
T.C -> min(m, n) + nlogn + mlogm
S -> 1

 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = 0;
        while(p1 >= 0 && p2 < n){
            if(nums1[p1] > nums2[p2]){
                int temp = nums1[p1];
                nums1[p1] = nums2[p2];
                nums2[p2] = temp;
                p1--;
                p2++;
            }else{
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}