/*
Brute: freqmap with array
T.C -> o(n) + o(nlogn)
S -> o(n) + o(n)
 */

/*
better: use hashmap and to reduce sorting we use priority queue
T.C -> o(n) + o(nlogk)
S -> o(n) + o(k)
 */

class Pair{
    int num, freq;
    Pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for(int num:nums){
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);
      
       for(Map.Entry<Integer, Integer> entry: fmap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            pq.add(new Pair(num, freq));

            if(pq.size() > k){
                pq.poll();
            }
       }
        int i = 0;
       while(pq.size() > 0){
        Pair temp = pq.poll();
        ans[i] = temp.num;
        i++;
       }

        return ans;
    }
}

/*
optimal: use hashmap and arraylist where freq is index
T.C -> o(2n)
S -> o(2n)
 */

class Pair{
    int num, freq;
    Pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for(int num:nums){
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

      List<Integer>[] bucket = new ArrayList[nums.length + 1];

       for(Map.Entry<Integer, Integer> entry: fmap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
           
           if(bucket[freq] == null){
            bucket[freq] = new ArrayList<>();
           }

        bucket[freq].add(num);
       }
        int idx = 0;
        for(int i = bucket.length-1 ; i >= 0; i--){
              if(bucket[i] != null){
                  for(int ele: bucket[i]){
                    ans[idx] = ele;
                    idx++;
                    if(idx == k) return ans;
                }
              }
        }

        return ans;
    }
}