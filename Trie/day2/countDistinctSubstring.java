/*
T.C -> o(n^2)
S -> 26*26*26...
 */

class Node{
    Node links[] = new Node[26];
    boolean flag;
    
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    
    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }
    
    Node get(char ch){
        return links[ch - 'a'];
    }
}

class GfG {
    public static int countDistinctSubstring(String st) {
      Node  root = new Node();
        int cnt = 0;
        for(int i = 0 ; i < st.length(); i++){
            Node node = root;
            for(int j = i; j < st.length() ; j++){
                char ch = st.charAt(j);
                if(!node.containsKey(ch)){
                    cnt++;
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
        }
        
        return cnt + 1;
    }
}