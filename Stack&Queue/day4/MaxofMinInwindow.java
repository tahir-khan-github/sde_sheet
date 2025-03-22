/*
Brute: use sliding window with k , where k -> 1 to n
T.c -> n^3
S->1
 */

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= arr.length; i++){
            ans.add(findMaxMinOfWindow(i, arr));
        }
        
        return ans;
    }
    
    public int findMaxMinOfWindow(int k , int []arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n - k + 1; i++){
           int min = arr[i];
            for(int j  = i; j < i + k; j++){
                min = Math.min(min, arr[j]);
            }
            max = Math.max(max, min);
        }
        
        return max;
    }
}

/*
Better: ds needed to store windows element also to find min in every window i need monotonic increasing stack
Both can be achieved using dqueue
T.C -> n^2
S -> n
 */
class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= arr.length; i++){
            ans.add(findMaxMinOfWindow(i, arr));
        }
        
        return ans;
    }
    
    public int findMaxMinOfWindow(int k , int []arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        Deque<Integer>  dq = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            if(!dq.isEmpty() && dq.peek() == i - k){
                dq.poll();
            }
            
            while(!dq.isEmpty() && arr[i] <= arr[dq.peek()]){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i >= i -k){
                max = Math.max(max, arr[dq.peek()]);
            }
        }
        
        return max;
    }
}

/*
Optimal: try to find an elem is smaller in which window size by nse - pse - 1;
T.C -> `= n
s -> 3n
 */
class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int prevSmall[] = prevSmaller(arr);
        int nextSmall[] = nextSmaller(arr);
        
        int ans[] = new int[arr.length];
        
        for(int i = 0 ; i < arr.length ; i++){
            int index =  nextSmall[i] - prevSmall[i] - 1;
             ans[index-1] = Math.max(arr[i], ans[index-1]);
        }
        
        for(int i = arr.length -2; i >= 0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : ans) {
            list.add(num);
        }
        
        return list;
    }
    
   public int[] prevSmaller(int arr[]){
       Stack<Integer> st = new Stack<>();
       int prevSmall[] = new int[arr.length];
       
       for(int i = 0 ; i < arr.length; i++){
           while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
               st.pop();
           }
           prevSmall[i] = st.isEmpty() ? -1 : st.peek();
           
           st.push(i);
       }
       
       return prevSmall;
   }
   
     public int[] nextSmaller(int arr[]){
       Stack<Integer> st = new Stack<>();
       int nextSmall[] = new int[arr.length];
       
       for(int i = arr.length - 1; i >= 0; i--){
           while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
               st.pop();
           }
           nextSmall[i] = st.isEmpty() ? arr.length : st.peek();
           
           st.push(i);
       }
       
       return nextSmall;
   }
}