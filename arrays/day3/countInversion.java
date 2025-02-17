//count inversion in an array

/*
Brute:- using 2 loops and maintaining count
T.C -> o(n^2)
 */

 {
    public static long getInversions(long arr[], int n) {
        int count = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = i+1; j<n ; j++){
                if(arr[i] > arr[j]) count++;
            }
        }

        return count;
    }
}

/*
Optimal:
Using merge sort , when two sorted arrays are merge based on arr[left] <= arr[right] or vice versa then we need to count
becoz 2 arrays are sorted so the count will (mid - left + 1) becoz if array is sorted then after left every elem will also make inversion 
pair becoz array is sorted.
T.C -> o(NlogN)
S -> o(N);
 */

public class Solution {
    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n-1);
    }

    public static long mergeSort(long []arr, int low, int high){
       long cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high)/2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    public static long merge(long []arr, int low,int mid, int high){
        long cnt = 0;
        ArrayList<Long> temp = new ArrayList<>();
        int left = low, right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
                cnt += mid - left + 1;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
          temp.add(arr[right]);
         right++;  
        }

        for(int i = low; i<= high; i++){
            arr[i] = temp.get(i-low);
        }

        return cnt;
    }
}