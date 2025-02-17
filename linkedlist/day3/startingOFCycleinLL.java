/*
Brute: using hashing check for duplicate node
T.C -> o(n 2logn)
S -> o(n)
 */
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();

        while(temp != null){
            if(map.containsKey(temp)){
                return temp;
            }

            map.put(temp,1);
            temp = temp.next;
        }

        return null;
    }


/*
optimal: using tortoise and hare technique
T.C -> o(n)
S -> o(1)
 */ 

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }