/*
Brute: traverse on 1 and store in hashmap, traverse on 2 and chceck for first same node return that node else return null at end
 */
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Boolean> map = new HashMap<>();
        ListNode t1 = headA, t2 = headB;

        while(t1 != null){
            map.put(t1, true);
            t1 = t1.next;
        }

        while(t2 != null){
            if(map.containsKey(t2)){
                return t2;
            }
            t2 = t2.next;
        }

        return null;

    }
}

/*
Better: find length of both LL, find difference move big ll till diff and then move both once they interact return t1
 */
 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        int c1 = 0;
        int c2 = 0;

        while(t1 != null){
            c1++;
            t1 = t1.next;
        }
        while(t2 != null){
            c2++;
            t2 = t2.next;
        }
       
        int d = c1 - c2;
        t1 = headA;
        t2 = headB;

        if(d < 0){ // ll2 is big
            while(d++ != 0) t2 = t2.next;
        }else{
            while(d-- != 0) t1 = t1.next;
        }


        while(t1 != null ){
           if(t1 == t2) return t1;
            t1 = t1.next;
            t2 = t2.next;
        }

        return null;

    }
 }

 /*
 optimal: switching to opposite heads when reached to null
 T.C -> o(l1+l2)
  */
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode t1 = headA, t2 = headB;

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2) return t1;

            if(t1 == null) t1 = headB;
            if(t2 == null) t2 = headA;
        }

        return t1;
    }
}