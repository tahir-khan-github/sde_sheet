/*
Approach: push and reverse queue to maintain top
T.C -> o(n) push
 */

class MyStack {
    Queue<Integer> q;

    public MyStack() {
       q = new LinkedList<>();;
    }
    
    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}