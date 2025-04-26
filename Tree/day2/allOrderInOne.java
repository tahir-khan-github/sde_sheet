/*
Approach:level order using stack instead of queue with 3 rules
if(num == 1)add node in preorder, num++, push left into stack
if(num == 2)add node in inorder, num++, push right into stack
if(num == 3)add node in postorder,
 */

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public void allTraversals(TreeNode root) {
        if (root == null) return;

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();

            if (curr.num == 1) {
                preorder.add(curr.node.val);
                curr.num++;
                stack.push(curr);

                if (curr.node.left != null) {
                    stack.push(new Pair(curr.node.left, 1));
                }
            } else if (curr.num == 2) {
                 
            } else {
                postorder.add(curr.node.val);
            }
        }

        // Output the traversals
        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }
}
