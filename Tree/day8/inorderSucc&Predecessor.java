/*
Approach: successor if(root.val <= key) go right else store ans and go right
        predecessor if(root.val >= key) go left else store ans and go right
T.C -> o(H)
S-> o(1)
 */
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
       pre[0] = predecessor(root, key);
       suc[0] = successor(root, key);
    }
    
    public static Node predecessor(Node root, int key){
        Node pre = null;
        while(root != null){
            
            if(root.data >= key){
                root = root.left;
            }else{
                pre = root;
                root = root.right;
            }
        }
        
        return pre;
    }
    
     public static Node successor(Node root, int key){
        Node suc = null;
        while(root != null){
            
            if(root.data <= key){
                root = root.right;
            }else{
                suc = root;
                root = root.left;
            }
        }
        
        return suc;
    }