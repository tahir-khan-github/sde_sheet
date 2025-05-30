/*
T.C -> o(n*32) + (m*32)
S -> 2 * 2 *2......
 */

class Node{
    Node links[] = new Node[2];
    boolean flag;
    
    boolean containsKey(int bit){
        return (links[bit] != null);
    }
    
    void put(int bit, Node node){
        links[bit] = node;
    }
    
    Node get(int bit){
        return links[bit];
    }
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    void insert(int num){
        Node node = root;
        for(int i = 31; i>= 0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num){
        Node node = root;
        int max = 0;
        for(int i = 31; i>= 0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 -bit)){
                max = max | (1 << i);
                node = node.get(1 - bit);
            }else{
                 node = node.get(bit);
            }
           
        }

        return max;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj = new Trie();
        for(int i = 0 ; i <nums.length; i++){
            obj.insert(nums[i]);
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i <nums.length; i++){
            maxi = Math.max(maxi, obj.getMax(nums[i]));
        }

        return maxi;
    }
}