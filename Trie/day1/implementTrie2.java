/*
T.C -> o(n) for all operation

 */

class Node{
    Node links[] = new Node[26];
    int ew = 0;
    int cp = 0;

    boolean containsKey(char ch){
        return (links[ch -'a'] != null);
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(ch, new Node());
            }
            node = node.get(word.charAt(i));
            node.cp += 1;
        }
        node.ew += 1;

    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node  = node.get(word.charAt(i));
        }

        return node.ew;
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(int i = 0 ; i < prefix.length(); i++){
            if(!node.containsKey(prefix.charAt(i))){
                return 0;
            }
            node  = node.get(prefix.charAt(i));
        }

        return node.cp;
    }

    public void erase(String word) {
                Node node = root;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return ;
            }
            node  = node.get(word.charAt(i));
            node.cp -= 1;
        }

        node.ew -= 1;
    }
}
