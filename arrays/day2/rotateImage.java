//Rotate Matrix by 90degree / rotate image
/*
transpose and reverse
 */

{
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        //tanspose
        for(int i = 0 ; i<n-1; i++){
            for(int j = i+1 ; j<m; j++){
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp;       
            }
        }

        reverse(matrix);
    }

    public void reverse(int[][]matrix){
        for(int []row: matrix){
            int p1 = 0, p2 = matrix.length -1;
            while(p1 < p2){
                int temp = row[p1];
                row[p1] = row[p2];
                row[p2] = temp;
                p1++;
                p2--;
            }
        }
    }
}