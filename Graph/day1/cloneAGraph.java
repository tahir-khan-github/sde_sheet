/*
DFS Appraoch: 1)clone the given node and store in the map
          2) dfs to travel on the next node(nbr)
          3)clone the nbr and store in the map
          4)attach cloned nbr with cloned node
T.C -> o(n) + o(2e) `= (n + e)
S -> o(n)
 */

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Node cloned_node = new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, cloned_node);
        dfs(node, cloned_node, map);

        return cloned_node;
    }

    Node dfs(Node node, Node cloned_node, HashMap<Node, Node> map){

        for(Node nbr: node.neighbors){
            if(!map.containsKey(nbr)){
                Node cloned_nbr = new Node(nbr.val);
                map.put(nbr, cloned_nbr);
                cloned_node.neighbors.add(cloned_nbr);
                dfs(nbr, cloned_nbr, map);
            }else{
                cloned_node.neighbors.add(map.get(nbr));
            }
        }

        return cloned_node;
    }
}

/*
BFS Approach
 */

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Node cloned_node = new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, cloned_node);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        bfs(q, map);

        return cloned_node;
    }

    void bfs(Queue<Node> q,  HashMap<Node, Node> map){

        while(!q.isEmpty()){
        Node node = q.remove();
        Node cloned_node = map.get(node);
        
        for(Node nbr: node.neighbors){
            if(!map.containsKey(nbr)){
                Node cloned_nbr = new Node(nbr.val);
                map.put(nbr, cloned_nbr);
                cloned_node.neighbors.add(cloned_nbr);
                q.add(nbr);
            }else{
                cloned_node.neighbors.add(map.get(nbr));
            }
        }
        }
    }
}