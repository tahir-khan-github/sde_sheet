//merge interval / merge sub interval
/*
1)sort the intervals
2)compare 1st elem of current interval with end elem of last interval
a)if it small we modify current merge interval
b)if it is big now we add the current merge interval into ans list and will pick new interval to make merge interval

T.C-> (NlogN) + (N)
s -> (N)
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });

        List<int[]> ans = new ArrayList<>();

        for(int i = 0 ; i < n; i++ ){
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}