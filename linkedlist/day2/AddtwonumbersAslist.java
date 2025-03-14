/*
Optimal: maintain sum and carry = sum / 10 and node = sum %10
T.C -> max(l1,l2)
S -> o(N)
 */
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int c = 0;

        while(l1 != null || l2 != null || c != 0){
            int sum = 0;
            if(l1 != null){
               sum += l1.val;
               l1 = l1.next; 
            }
            if(l2 != null){
               sum += l2.val;
               l2 = l2.next; 
            }
            sum += c;
            c = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
        
    }
}