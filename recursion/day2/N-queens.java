/*
Approach: fill queen column wise using recursion and check isSafe
T.C -> o(n!*3n) + o(n)
s -> o(n*m)
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for(char row[]: board){
            Arrays.fill(row, '.');
        }

        helper(0, board, ans);

        return ans;
    }

    public void helper(int col, char board[][], List<List<String>> ans){
        if(col == board[0].length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0 ; row < board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    public List<String> construct(char board[][]){
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i< board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }

    public boolean isSafe(int row, int col, char board[][]){
        int duplicateRow = row;
        int duplicateCol = col;

        while(row >= 0 && col >= 0){
           if( board[row][col] == 'Q') return false;
           row--;
           col--;
        }
        row = duplicateRow;
        col = duplicateCol;

        while(col>= 0){
          if( board[row][col] == 'Q') return false;
           col--;
        }

        row = duplicateRow;
        col = duplicateCol;

        while(row < board.length && col >= 0){
           if( board[row][col] == 'Q') return false;
           row++;
           col--;
        }

        return true;

    }
}

/*
Optimized: isSafe function can be optimized using hashing on 3 check direction
T.C -> n*n
S-> (2n-1) + (2n - 1) + (k*n)
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        int leftRow[] = new int[n];
        int downDiag[] = new int[2*n-1];
        int upDiag[] = new int[2*n-1];

        for(char row[]: board){
            Arrays.fill(row, '.');
        }

        helper(0, board, ans, leftRow, downDiag, upDiag,n);

        return ans;
    }

    public void helper(int col, char board[][], List<List<String>> ans, int leftRow[], int downDiag[], int upDiag[], int n){
        if(col == board[0].length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0 ; row < board.length; row++){
            if(leftRow[row] == 0 && downDiag[row+col] == 0 && upDiag[(n-1) + (col-row)] == 0){
                leftRow[row] = 1;
                downDiag[row+col] = 1;
                upDiag[(n-1) + (col-row)] = 1;
                board[row][col] = 'Q';
                helper(col + 1, board, ans, leftRow, downDiag, upDiag,n);
                leftRow[row] = 0;
                downDiag[row+col] = 0;
                upDiag[(n-1) + (col-row)] = 0;
                board[row][col] = '.';
            }
        }
    }

    public List<String> construct(char board[][]){
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i< board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }
}