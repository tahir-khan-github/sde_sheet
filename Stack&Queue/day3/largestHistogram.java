/*
brute: traverse and compute area = arr[i] * (nse[i] - pse[i] - 1);
T.C -> 2n + 2n + n = 5n
S -> 2n + 2n = 4n
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int pse[] = findPse(heights);
        int nse[] = findNse(heights);

        for(int i = 0 ; i < heights.length; i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);
        }

        return max;
    }

     public int [] findPse(int arr[]) {
        int pse[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            
            st.push(i);
        }
        
        return pse;
    }

    public int[] findNse(int arr[]){
        int nse[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length - 1 ; i>= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = arr.length;
            }
            else{
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;
    }
}


/*
Optimal: compute in one go
pse(st.peek) while passing by, and while doing so calculate nse(arr[i]) and elem = st.pop
area = arr[elem] * (nse[i] - pse[i] - 1)
T.C -> 2n
S -> n
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int nse = 0, pse = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
               int elem = st.pop();
               nse = i;
               pse = st.isEmpty() ? -1 : st.peek();

               int area = heights[elem] * (nse - pse - 1);
               max = Math.max(max, area);
            }
            
            st.push(i);
        }

         while(!st.isEmpty()){
               int elem = st.pop();
               nse = heights.length;
               pse = st.isEmpty() ? -1 : st.peek();

               int area = heights[elem] * (nse - pse - 1);
               max = Math.max(max, area);
            }


        return max;
    }
}

   
