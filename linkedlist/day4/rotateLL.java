/*
Optimal: find tail, point tail to head, find diff node make new head as diff.next and make diff.next to null. also handle edge case of k
T.C -> o(n) + o(l-k)
S->o(1)
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         if (head == null) return null;
        int len = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
       
        if(k % len == 0) return head;
         k = k % len;
        
         tail.next = head;

        int end = len - k;
        ListNode temp = head;
        for(int i = 1 ; i < end; i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }
}