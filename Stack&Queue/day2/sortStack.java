/*
Approach: pop , call recursion, while coming back inser in sorted manner,  
sortInsert -> pop till num > top then insert at base
T.C -> o(n^2)
S-> o(n)
 */

public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()){
			return;
		}

		int num = stack.pop();
		sortStack(stack);

		sortInsert(stack, num);
	}

	public static void sortInsert(Stack<Integer> stack, int num){
		if(stack.isEmpty() || num > stack.peek()){
			stack.push(num);
			return;
		}

		int n = stack.pop();
		sortInsert(stack, num);

		stack.push(n);
	}

}