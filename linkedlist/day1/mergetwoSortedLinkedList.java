/*
Brute: add 2 list into arraylist then sort it and convert sorted list to new linked list
T.C -> o(n1)+o(n2)+o(NlogN) + o(N)
S -> o(N)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        ArrayList<Integer> list = new ArrayList<>();

        ListNode t1= list1, t2 = list2;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
               list.add(t1.val);
                t1 = t1.next;
            }else{
                list.add(t2.val);
                t2 = t2.next;
            }
        }
        while(t1 != null){
             list.add(t1.val);
             t1 = t1.next;
        }
          while(t2 != null){
             list.add(t2.val);
             t2 = t2.next;
        }
        ListNode head = convert(list);

        return head;
    }

    public ListNode convert(ArrayList<Integer> list){
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for(int el: list){
            curr.next = new ListNode(el);
            curr = curr.next;
        }

        return head.next;
    }
}
/*
Optimal: use sorted property and two pointer , move and compare and change direction
T.C -> o(n1 + n2);
S -> o(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        ListNode t1= list1, t2 = list2;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                temp.next = t1;
                t1 = t1.next;
                temp = temp.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
                temp = temp.next;
            }
        }
        while(t1 != null){
             temp.next = t1;
             t1 = t1.next;
            temp = temp.next;
        }
          while(t2 != null){
             temp.next = t2;
             t2 = t2.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
 */