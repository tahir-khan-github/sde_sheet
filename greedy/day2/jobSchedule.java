/*
Approach: max profit, put jobs to end days
T.C -> o(n) + o(nlogn) + o(n) + o(n * maxJobs) 
s -> o(2n)
 */
class Jobs{
    int id, deadline, profit;
    Jobs(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class jobComparator implements Comparator<Jobs>{
    @Override
    public int compare(Jobs j1, Jobs j2){
        return j2.profit - j1.profit;
    }
}

class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        ArrayList<Jobs> list = new ArrayList<>();
        int maxDeadline = deadline[0];
        for(int i = 0 ; i < id.length; i++){
            maxDeadline = Math.max(maxDeadline, deadline[i]);
            list.add(new Jobs(id[i], deadline[i], profit[i]));
        }
        
        Collections.sort(list, new jobComparator());
        int days[] = new int[maxDeadline +1];
        
        Arrays.fill(days, -1);
        
        int countJobs = 0, jobProfit = 0;
        
        for(Jobs el : list){
            for(int i = el.deadline; i>=1; i--){
                if(days[i] == -1){
                    countJobs++;
                    jobProfit += el.profit;
                    days[i] = el.id;
                    break; 
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(countJobs);
        ans.add(jobProfit);
        
        return ans;
    }
}