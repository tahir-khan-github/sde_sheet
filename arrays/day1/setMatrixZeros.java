// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.


/* Brute force
if we try to mark it directly 0 it will make 1 to zero and then for that 1 we will again be marking 0 so its wrong,
What we can do is we mark 1s to -1 in 1st iteration and then in 2nd iteration we mark -1 to 0 
T.C -> (n*m)*(n+m) + (n*m) `= n^3
*/ 
class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    markRow(i, matrix);
                    markCol(j, matrix);
                }
            }
        }

           for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void markRow(int i, int[][] matrix){
        for(int j = 0 ; j < matrix[0].length; j++){
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }

       public void markCol(int j, int[][] matrix){
        for(int i = 0 ; i < matrix.length; i++){
              if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }
}


/* Better
we are marking with seperate iteration so inorder avoid that we can do marking using col mark and row mark arrays
if in any row or col we get even one 0 that means that entire row and col will be marked using mark arrays
so in 2nd iteration if any of the row or col array is marked we mark it
T.C -> (n*m) + (n*m) `= 2*(n*m)
S.C -> (n+m)
*/ 
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int []row = new int[matrix.length];
        int []col = new int[matrix[0].length];

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }

           for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(row[i] == -1 || col[j] == -1 ){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/* Optimal
Need to reduce space complexity so we do inplace we will remove extra marking array and we make row[0] -> as col mark and col[0] -> row mark
but for arr[0][0] there will be a colision so we take extra variabble col0
and for 2nd iterartion we need to iterate frm i+1 and j+1 becoz row[0] and col[0] are marking array now
and then we handle 1st row -> matrix[0][0] and 1st col -> col0
T.C -> (n*m) + (n*m) `= 2*(n*m)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; //row marking
                  if(j != 0){ //col marking
                      matrix[0][j] = 0;
                  }else{
                    col0 = 0;
                  }
                }
            }
        }

           for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[0].length ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
           }
          if(matrix[0][0] == 0){ //marked col marking
                for(int j = 0 ; j < matrix[0].length; j++){
                    matrix[0][j] = 0;
                }
            }

            if(col0 == 0){ //marked row marking
                for(int i = 0 ; i < matrix.length; i++){
                    matrix[i][0] = 0;
                }
            }
    }
}

