/*
Brute: use set to find distinct elem in every window
T.C -> o(n*k)
S-> o(k)
 */

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new  ArrayList<>();
        
        for(int i = 0 ; i <= n - k; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i; j< i+k; j++){
                set.add(arr[j]);
            }
            ans.add(set.size());
        }
        
        return ans;
    }
}

/*
optimal: remove[i-k] add[i] , with hashmap
T.C -> o(n)
S -> o(k)
 */

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new  ArrayList<>();
        HashMap<Integer, Integer> fmap = new HashMap<>();
        
        for(int i = 0 ; i < k; i++){
           fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
        }
        
        ans.add(fmap.size());
        
        for(int i = k ; i < n; i++){
            if(fmap.get(arr[i-k]) == 1){
                fmap.remove(arr[i-k]);
            }else{
                fmap.put(arr[i-k], fmap.get(arr[i-k]) - 1);
            }
            
            fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
            ans.add(fmap.size());
        }
        
        return ans;
    }
}