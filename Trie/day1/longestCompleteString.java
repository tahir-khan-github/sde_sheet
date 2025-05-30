/*
T.C -> o(n) * o(len)
 */

class Node{
    Node links[] = new Node[26];
    boolean flag;
    
    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    
    void put(char ch, Node node){
        links[ch - 'a'] = node;
        
    }
    
    Node get(char ch){
        return links[ch - 'a'];
    }
    
    boolean isEnd(){
        return flag;
    }
    
    void setEnd(){
        flag = true;
    }
}

class Trie{
    private Node root;
    
    Trie(){
        root = new Node();
    }
    
    public void insert(String word){
        Node node = root;
        for(int i = 0 ; i < word.length() ;i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    boolean checkPrefix(String word){
        Node node = root;
        for(int i = 0 ; i < word.length() ;i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            
            node = node.get(ch);
            if(!node.isEnd()){
                return false;
            }
        }
        
        return true;
    }
}

class Solution {
    public String longestValidWord(String[] words) {
       Trie obj = new Trie();
       
       for(String word: words){
           obj.insert(word);
       }
       
       String longest = "";
       
       for(String word: words){
           if(obj.checkPrefix(word)){
               if(word.length() > longest.length()){
                   longest = word;
               }else if(word.length() == longest.length() && word.compareTo(longest) < 0){
                   longest = word;
               }
           }
       }
       
       if(longest.length() == 0) return "";
       
       return longest;
    }
}