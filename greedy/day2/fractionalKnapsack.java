/*
Appraoch -> sort based on max value per 1 unit
T.C -> 2n + nlogn
S-> o(3 *n)
 */
class Knapsack{
    int val, wt, ratio;
    Knapsack(int val, int wt, int ratio){
        this.val = val;
        this.wt = wt;
        this.ratio = ratio;
    }
}

class knapsackComparator implements Comparator<Knapsack>{
    @Override
    public int compare(Knapsack k1, Knapsack k2){
        return k2.ratio - k1.ratio;
    }
}


class Solution {
    
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
       ArrayList<Knapsack> list=new ArrayList<>();
       
       for(int i = 0 ; i < val.size(); i++){
           list.add(new Knapsack(val.get(i), wt.get(i), val.get(i)/wt.get(i)));
       }
       
       Collections.sort(list, new knapsackComparator());
       
       double total = 0.0;
       
       for(Knapsack el: list){
           if(el.wt <= capacity){
               total += el.val;
               capacity = capacity - el.wt;
           }else{
               total += (el.val/el.wt)*capacity;
           }
       }
       
       return total;
    }
}