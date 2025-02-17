//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//so 0,1,2 such that same number becomes adjacent of each other
//[2,0,2,1,1,0] -> [0,0,1,1,2,2]

/*
optimal -> use merge sort
T.C -> (NlogN), S-> (N)
 */

/**
 Better -> use count technique
 T.C-> (2N)
 */
 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0) c0++;
            if(nums[i] == 1) c1++;
            if(nums[i] == 2) c2++;
        }
        for(int i = 0 ; i < c0 ; i++){
            nums[i] = 0;
        }
          for(int i = c0 ; i < c0+c1 ; i++){
            nums[i] = 1;
        }
          for(int i = c0+c1 ; i < n ; i++){
            nums[i] = 2;
        }
    }
}

/**
 Optimal-> use Dutch National Flag algo
 T.C -> o(N)
 */

 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

