/*
Doublylinked list and hasmap
 */

class Node{
    Node prev, next;
    int key, val;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int cap;
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
          head.next = tail;
            tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size() == cap){
                Node node = tail.prev;
                deleteNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);
        }
    }

    public void deleteNode(Node node){
        Node afterNode = node.next;
        Node beforeNode = node.prev;
        beforeNode.next = afterNode;
        afterNode.prev = beforeNode;
    }

    public void insertAfterHead(Node node){
        Node afterHead = head.next;
        node.next = afterHead;
        afterHead.prev = node; 
        head.next = node;
        node.prev = head;
    }
}
