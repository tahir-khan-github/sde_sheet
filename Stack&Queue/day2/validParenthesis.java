/*
Approach: at any closing bracket need to check which one was last opening , which can be done using stack
push on open 
comapare and pop on close
T.C -> o(n)
S -> o(n)
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if((s.charAt(i) == ')' && top == '(') || (s.charAt(i) == '}' && top == '{') || (s.charAt(i) == ']' && top == '[')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}