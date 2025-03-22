/*
Approach1: if push is less (s1->s2, x->s1, s2 -> s1)
T.C -> 2n push
 */

class MyQueue {
      Stack<Integer> s1;
      Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while(s1.size() != 0){
            s2.push(s1.pop());
        }

        s1.push(x);

        while(s2.size() != 0){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        if(s1.size() == 0) return true;

        return false;
    }
}

/*
Approach2: if push is more  pop(s2 ! empty -> s2.pop(), s2 empty -> s1-> s2 s2.pop()) , top(s2 ! empty -> s2.top(), s2 empty -> s1-> s2 s2.top() ) 
T.C -> n pop, n top
 */
class MyQueue {
      Stack<Integer> s1;
      Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.size() != 0){
            return s2.pop();
        }else{
            while(s1.size()>0){
                s2.push(s1.pop());
            }

            return s2.pop();
        }
    }
    
    public int peek() {
        if(s2.size() != 0){
          return s2.peek();
        }else{
            while(s1.size()>0){
                s2.push(s1.pop());
            }

           return s2.peek();
        }
    }
    
    public boolean empty() {
      return  s1.empty() && s2.empty();
    }
}