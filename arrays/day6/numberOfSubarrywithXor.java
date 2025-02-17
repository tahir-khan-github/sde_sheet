/*
Brute: generate all subarray
T.C -> n^2
S-> 1
 */
 {
    public int solve(int[] A, int B) {
        int n = A.length;
        int cnt = 0;
        for(int i = 0; i < n ; i++){
            int xor = 0;
            for(int j = i ; j < n ; j++){
                xor = xor ^ A[j];
                if(xor == B) cnt++;
            }
        }
        
        return cnt;
    }
}

/*
optimal: prefix xor and find value of x if it exist increase count by frequency
T.C -> nlogn
S -> n
 */

 {
    public int solve(int[] A, int B) {
        int n = A.length;
        int cnt = 0;
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i = 0; i < n ; i++){
            xr = xr ^ A[i];
            if(map.containsKey(xr^B)){
                cnt += map.get(xr^B);
            }
            if(map.containsKey(xr)){
                map.put(xr, map.get(xr) + 1);
            }else{
                map.put(xr,1);
            }
        }
        
        return cnt;
    }
}

