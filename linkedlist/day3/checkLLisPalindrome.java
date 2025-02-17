/*
Brute: using stack
 T.C -> o(2n)
 S->o(n)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            ListNode node = st.pop();
            if(node.val != temp.val) return false;
            temp = temp.next;
        }

        return true;
    }
}

/*
Optimal: use slow and fast pointer to check for mid, then reverse mid+1 , then compare 
T.C -> o(n/2) + o(n/2) + o(n/2) `= o(n)
S -> o(1)
 */
 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode t1 = head, t2 = newHead;
        while(t2 != null){
            if(t1.val != t2.val) return false;
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode dummyNode = null;

        while(head != null){
            ListNode nextNode = head.next;
            head.next = dummyNode;
            dummyNode = head;
            head = nextNode;
        }

        return dummyNode;
    }
}