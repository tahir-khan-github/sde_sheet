/*
Brute: count total node and evaluate mid then run loop till mid and move dummy
T.C -> o(n) + o(n/2)
S -> o(1)
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        int count = 0;
        while(dummy != null){
            count++;
            dummy = dummy.next;
        }
        int mid = count/2;

        dummy = head;
       for(int i = 1; i<= mid; i++){
        dummy = dummy.next;
       }

        return dummy;
    }
}

/*
Optimal: fast and slow pointer
T.C -> o(n/2)
S -> o(1)
 */
{
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
   
    }
}