/*
Brute: using pair class to keep track of min val
T.c -> o(1)
S -> o(2n)
 */

class MinStack {
   
    class Pair{
        int val, minVal;
        Pair(int _val, int _minVal){
            this.val = _val;
            this.minVal = _minVal;
        }
    }

     Stack<Pair> st;

    public MinStack() {
      st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val, val));
        }else{
            st.push(new Pair(val, Math.min(val, st.peek().minVal)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().minVal;
    }
}

/*
Optimal: using maths formula st.push(2*val - prevMin) to store , and to revert mini = (2 *mini - x)
T.C -> o(1)
S ->o(1)
 */

class MinStack {

     Stack<Long> st;
     long mini;

    public MinStack() {
      st = new Stack<>();
      mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long value = (long)val;
        if(st.isEmpty()){
            st.push(value);
            mini = value;
        }else{
            if(value > mini) st.push(value);
            else{
                st.push(2*value - mini);
                mini = value;
            }
        }
    }
    
    public void pop() {
       if (st.isEmpty()) return;

        long x = st.pop();
        if (x < mini) { // Means it was an encoded value
            mini = 2 * mini - x; // Restore previous minimum
        }

        if (st.isEmpty()) mini = Long.MAX_VALUE; // ✅ Reset mini when stack is empty
    }
    
    public int top() {
        long x = st.peek();
        if(x < mini) return (int)mini;

        return (int)x;
    }
    
    public int getMin() {
        return (int)mini;
    }
}
