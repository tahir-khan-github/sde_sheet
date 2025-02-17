/*
Brute: if cycle exist then a node will be visited again and we check using hashmap
T.c -> o(n) + o(2logn)
S -> o(n)
 */
 {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = head;

        while(temp != null){
            if(map.containsKey(temp)) return true;

            map.put(temp,1);
            temp = temp.next;
        }

        return false;
    }
}

/*
Optimal: slow and fast pointer , slow moves 1 and fast moves 2 steps and once they collide return true
T.C -> o(n)
S-> o(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode slow = head, fast = head;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(fast == slow) return true;
      }

        return false;
    }
}