/*
Brute: count total node , then do res =n - cnt  then iterate till res and change the link
T.C -> o(2n)
S->o(1)
 */
 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int cnt = 0;

        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        
        if(cnt == n) return head.next;

        int res = cnt - n;
       
        temp = head;
        while(temp != null){
            res--;
            if(res == 0) break;
            temp = temp.next;
        }


        ListNode deletedNode = temp.next;
        temp.next = temp.next.next;

        return head;
    }
}

/*
optimal: two pointer apporach with creating gap of N
T.C -> o(n)
s-> o(1)
 */
 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 1; i<= n ;i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
 }