/*
Brute: iterate using 2 loops and cnt++ when a[i] > 2 * a[j]
 */


/*
Optimal: using merge sort
figure out the count of pairs which is i(low to n) and right++ and cnt = right - (mid + 1)
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int arr[], int low, int high){
        int cnt = 0;
        if(low >= high) return (int)cnt;
        int mid = (low + high)/2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return cnt; 
    }

    public int countPairs(int arr[], int low, int mid, int high) {
        int cnt = 0, right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) { // FIXED OVERFLOW ISSUE
                right++;
            }
            cnt += right - (mid + 1);
        }

        return cnt;
    }

    public void merge(int arr[], int low, int mid, int high){
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid  + 1;

        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }

        while(left <= mid){
            list.add(arr[left]);
            left++;
        }

        while(right <= high){
            list.add(arr[right]);
             right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = list.get(i-low);
        }

        return;
    }
}