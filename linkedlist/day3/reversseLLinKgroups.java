/*
Optimal: follow diagram
T.C -> o(2n)
S -> o(1)
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null ||  k==1) return head;

        ListNode temp = head, nextNode = null, prevLast = null;

        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }
                prevLast = temp;
                temp = nextNode;

        }
        return head;
    }

    public ListNode getKthNode(ListNode temp, int k){
        k--;
        while(temp != null && k>0){
            k--;
            temp = temp.next;
        }

        return temp;
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