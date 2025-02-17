/*
Brute: Use hashmap to create a copy of LL, then iterate again and map random and next using hasmap
T.C -> (2nlogn)
S -> o(n)
 */
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}

/*
optimal: insert in b/w, map random pointer, map next pointer
T.C -> o(3n)
S->o(1)
 */
 {
    public Node copyRandomList(Node head) {
        insertInBetween(head);
        mapRandomPointers(head);

       return mapNextPointers(head);
    }

    public void insertInBetween(Node head){
        Node temp = head;

        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
          
            temp = temp.next.next;
        }
    }

    public void mapRandomPointers(Node head){
          Node temp = head;

        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }else{
                copyNode.random = null;
            }

            temp = temp.next.next;
        }
    }

    public Node mapNextPointers(Node head){
        Node temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while(temp != null){
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }


}