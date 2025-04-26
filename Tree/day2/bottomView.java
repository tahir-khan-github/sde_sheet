/*
Approach : level order line wise, (use map to remove duplicate so that last elem of each horizontal line can be stored)
T.C -> o(n)
S -> o(n)
 */

class Solution
{
    
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList <Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map= new TreeMap<>();
        
        Queue<Node> q = new LinkedList<>();
        
        root.hd = 0;
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            map.put(temp.hd, temp.data);
            
            if(temp.left != null){
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }
        
        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            ans.add(set.getValue());
        }
        
        return ans;
    }
}