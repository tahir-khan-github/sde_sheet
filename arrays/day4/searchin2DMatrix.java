//search in sorted 2D matrix

/*
Brute force: iterarte on matrix and compare each elem with target
T.C -> o(n*m)
 */
{
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

/*
As the matrix is sorted we can compare fast and last elem with target at each row and then when condition fulfill we do binary search on
that row
T.C -> o(n) + o(log2 n)
 */

{
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            if(matrix[i][0] <= target && matrix[i][m-1] >= target) return binarySearch(matrix[i],0,m-1,target);
        }
        return false;
    }
    public boolean binarySearch(int arr[], int low, int high, int target){
        while(low <= high){
          int mid = (low + high)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] <= target) low = mid+1;
            else high = mid -1;
        }
        return false;
    }
}

/*
optimatal : hypothetical flatten the array and then apply binary search find mid, now find row, col using formula of index -> row, col
row = idx/col -> this works because 1st column is always be in multiple of col length(m)
col = idx%col -> this works because cols are from 0 to m and % will give remainder from 0 to m
 */

{
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n*m -1;
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid -1;
        }

        return false;
    }
}
