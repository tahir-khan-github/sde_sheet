/*
Brute: traverse and store all val into list, sort the list and then convert list into Linked list
 */

{
    Node flatten(Node root) {
        Node t1 = root;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(t1 != null){
            Node t2 = t1;
            while(t2 != null){
                list.add(t2.data);
                t2 = t2.bottom;
            }
            t1 = t1.next;
        }
        
        Collections.sort(list);
        Node newHead = convert(list);
        
        return newHead;
    }
    
    Node convert(ArrayList<Integer> list){
        Node head = new Node(list.get(0));
        
        Node temp = head;
        int idx = 1;
        
        while(idx < list.size()){
            Node node = new Node(list.get(idx));
            temp.bottom = node;
            temp = temp.bottom;
            idx++;
        }
        
        return head;
    }
}

/*
optimal: merge two sorted Linked list + recursion
 */

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root == null || root.next == null){
            return root;
        }
        Node root2 = flatten(root.next);
        
        return merge(root, root2);
    }
    
    Node merge(Node t1, Node t2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                temp.bottom = t1;
                t1 = t1.bottom;
            }else{
                temp.bottom = t2;
                t2 = t2.bottom; 
            }
            
            temp = temp.bottom;
        }
        if(t1 != null){
            temp.bottom = t1;
        }else{
            temp.bottom = t2;
        }
        
        return dummy.bottom;
        
    }
}