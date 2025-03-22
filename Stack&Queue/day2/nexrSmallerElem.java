/*
Brute: use two loop
T.C -> o(n^2)
s ->1
 */
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> nse = new ArrayList<>();
        for(int i = 0; i < A.size(); i++){
            boolean found = false;
            for(int j = i-1; j >= 0; j--){
                if(A.get(j) < A.get(i)){
                    nse.add(A.get(j));
                    found = true;
                    break;
                }
            }
            if(!found) nse.add(-1);
        }
        
        return nse;
    }
}

/*
Optimal : use stack like nge
T.C -> o(n)
S-> o(n)
 */

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> nse = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < A.size(); i++){
            while(!st.isEmpty() && st.peek() >= A.get(i)){
                st.pop();
            }
            if(st.isEmpty()) nse.add(-1);
            else nse.add(st.peek());
            
            st.push(A.get(i));
        }
        
        return nse;
    }
}
