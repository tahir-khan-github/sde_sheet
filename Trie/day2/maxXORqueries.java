/*

 */
class Node{
    Node links[] = new Node[2];

    boolean containsKey(int bit){
        return links[bit] != null;
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
        for(int i = 31; i >=0 ; i--){
            int bit = (num>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    int getMax(int num){
        Node node = root;
        int max = 0;
        for(int i = 31; i >=0 ; i--){
            int bit = (num>>i) & 1;
            if(node.containsKey(1 - bit)){
                max = max | (1<<i);
                node = node.get(1- bit);
            }else{
                node = node.get(bit);
            }
        }

        return max;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int[][] offlineQueries = new int[queries.length][3];

        for(int i = 0 ; i < queries.length; i++){
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }

        Arrays.sort(offlineQueries, (a,b)-> Integer.compare(a[1], b[1]));

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < queries.length; i++){
            ans.add(-1);
        }

        Trie  trie = new Trie();
        int idx = 0;
        for(int i = 0 ; i < offlineQueries.length; i++){
            int xi = offlineQueries[i][0];
            int ai = offlineQueries[i][1];
            int qIdx = offlineQueries[i][2];

            while(idx < nums.length && nums[idx] <= ai){
                trie.insert(nums[idx]);
                idx++;
            }

            if(idx == 0){
                ans.set(qIdx, -1);
            }
            else{
                ans.set(qIdx, trie.getMax(xi));
            }
        }


        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i); 
        }
         return result;
    }
}