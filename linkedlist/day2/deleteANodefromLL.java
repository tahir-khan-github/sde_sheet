/*
optimal: just put node next value into itself and change pointer to next->next
T.c-> o(1)
s-> o(1)
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}