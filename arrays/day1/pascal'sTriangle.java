/*
there are 3 variations of questions and we use (nCr) = n! / (r! * (n-r)!) in pascal triangle with ( r-1Cc-1)
 */

/*
variation 1) given row and col find the value

as a brute force we use formula (nCr) = n! / (r! * (n-r)!) and find factorial but this will take too much time
so drive the formula 
Assume, given r = 7, c = 4. 
Now, n = r-1 = 7-1 = 6 and r = c-1 = 4-1 = 3
Let’s calculate 6C3 = 6! / (3! *(6-3)!) = (6*5*4*3*2*1) / ((3*2*1)*(3*2*1))
This will boil down to (6*5*4) / (3*2*1) or can we written as (6*5*4) / (1*2*3)
i -> 0 to r 
res = res * (n-i);
res = res / (i+1);
T.C -> (r)
*/
class solution{
 public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }
}

/*
variation 2) given row and col find the whole row

brute force
we observe that the n-th row of the triangle has exactly n elements so we iterate on columns to put row and col in formula
nCr = r-1Cc-1
 */

{ 
     public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }
}

/*
optimal apporach is to implement above formula on the last row and observe more
nCr = (r-1Cc-1)  = 1, 5, 10, 10, 5, 1

  1, 5/1, 5 *4/1* 2, 5*4 *3/1*2 *3, 5*4*3 *2/1*2*3 *4, 5*4*3*2* 1/1*2*3*4 *5

  so if iterate with 0 based indexing but start with 1 (as 1st ans will always be 1), on col we find we are doing (ans * (row-col)/col)
T.C-> o(N)
 */

{
      static void pascalTriangle(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}

/*
variation 3) print whole pascal triangle

brute force
is to print the triangle using nCr = r-1Cc-1 = (n-i)/(i+1)
for(int i = 1 to n){
  temp[]
    for(int j = 1 to i){
     temp.add(nCr(i-1, j-1))
    }
   ans.add(temp)  
}
T.C-> (n*n*r) `= n^3


optimal :
use variation2 derived formula (row-col)/col to find row
 T.C -> o(n*n)
 */

class Solution {
    public List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add((int)ans);
        for(int col = 1 ; col < row; col++){
            ans = ans *(row - col);
            ans = ans/(col);
            res.add((int)ans);
        }

        return res;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1 ; i<= numRows ; i++){
            ans.add(generateRow(i));
        }

        return ans;
    }
}




