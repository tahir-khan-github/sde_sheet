/*
Brute: Compare each character of 1st str with character of all str , make ans til match
T.c -> o(n^2)
S-> o(1)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < strs[0].length();i++){
            char ch = strs[0].charAt(i);

            boolean match = true;
            for(int j = 1 ; j < n ; j++){
                if(ch != strs[j].charAt(i)){
                    match = false;
                    break;
                }
            }
            if(match == false) break;

            sb.append(ch);
        }

        return sb.toString();
    }
} 

/*
Appraoch: Trie implementation as its check for string prefix
T.c -> n*m
S-> n
 */

class TrieNode{
    boolean isEndOfWord;
    TrieNode children[] = new TrieNode[26];
    int countChild = 0;
}

class Trie{
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode crawler = root;

        for(char ch: word.toCharArray()){
            int idx = ch - 'a';
            if(crawler.children[idx] == null){
                crawler.children[idx] = new TrieNode();
                crawler.countChild++;
            }
            crawler = crawler.children[idx];
        }

        crawler.isEndOfWord = true;
    }


    public String lcp(){
        TrieNode crawler = root;
        StringBuilder sb = new StringBuilder();

        while(crawler.countChild == 1 && !crawler.isEndOfWord){
            for(int i = 0 ; i < 26; i++){
                if(crawler.children[i] != null){
                    sb.append((char) ('a' + i));
                    crawler = crawler.children[i];
                    break;
                }
            }
        }

        return sb.toString();
    }
}

class Solution {

    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) return "";

           Trie trie = new Trie();

            for (String word : strs) {
            trie.insert(word);
        }

        return trie.lcp();
    }
}