/*
Brute: knowsme arr, iknow arr
T.C -> n^2 + n
S -> 2n
 */

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int knowsMe[] = new int[n];
        int iKnow[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i!= j && mat[i][j] == 1){
                    knowsMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        
        for(int i = 0 ; i < n; i++){
            if(knowsMe[i] == n -1 && iKnow[i] == 0){
                return i;
            }
        }
        
        
        return -1;
    }
}

/*
Optimal: inset all in stack, pop 2 at a time and push back the one who don't know other and at the end verify the celeb
T.C -> 4n `= n
s -> n
 */

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i <n ;i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            
            if(mat[a][b] == 1) st.push(b);
            else st.push(a);
        }
        
        int celeb = st.pop();
        
        //if celeb then  row is 0
        for(int j = 0 ; j < n ; j++){
            if(mat[celeb][j] == 1 && j!=celeb) return -1;
        }
        
        //if celeb then colum contains 1 except diag
        for(int i = 0 ; i < n ;i++){
            if(mat[i][celeb] == 0 && i!=celeb) return -1;
        }
        
        
        return celeb;
    }
}

/*
Space optimize: remove stack and use 2 pointer
T.c -> o(3n)
s-> o(1)
 */
class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int a = 0;
        int b = n-1;   
        
        while(a < b){
            
            if(mat[a][b] == 1) a++;
            else b--;
        }
        
        int celeb = a;
        
        //if celeb then  row is 0
        for(int j = 0 ; j < n ; j++){
            if(mat[celeb][j] == 1 && j!=celeb) return -1;
        }
        
        //if celeb then colum contains 1 except diag
        for(int i = 0 ; i < n ;i++){
            if(mat[i][celeb] == 0 && i!=celeb) return -1;
        }
        
        
        return celeb;
    }
}