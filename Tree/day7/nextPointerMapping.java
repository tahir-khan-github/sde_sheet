/*
Appraoch: assume prev is solved 
        curr.l.next = curr.r
        if(curr.next == null) break
        curr.right.next = curr.next.left
        curr = curr.next
T.C -> o(n)
S -> o(1)
 */

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node curr = root;
        while(curr.left != null){
            Node temp = curr;
            while(true){
                curr.left.next = curr.right;
                if(curr.next == null) break;
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr = temp.left;
        }

        return root;
    }
}