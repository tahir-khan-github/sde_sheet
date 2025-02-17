/*
brute: point head next to dummy and then move dummy to head and head to next
T.C -> o(n)
S->o(1)
 */

 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = null;

        while(head != null){
            ListNode next = head.next;
            head.next = dummyNode;
            dummyNode = head;
            head = next;
        }

        return dummyNode;
    }
}
