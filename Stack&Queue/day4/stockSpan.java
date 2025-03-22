/*
Brute: traverse back in the list to count the values <=
T.C -> o(num of days  per next call)
S -> o(no of next calls)
 */

class StockSpanner {

    ArrayList<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int cnt = 1;

        for(int i = list.size()-2; i>=0 ;i--){
            if(list.get(i) <= price) cnt++;
            else break;
        }

        return cnt;
    }
}


/*
Optimal: using previous greater element
T.C -> o(2n) overall
S -> o(n)
 */

class StockSpanner {

    class Pair {
        int val, index;
        Pair(int _val, int _index){
            this.val = _val;
            this.index = _index;
        }
    }

    Stack<Pair> st;
    int idx;

    public StockSpanner() {
        idx = -1;
        st = new Stack<>();
    }
    
    public int next(int price) {
       idx = idx + 1;

       while(!st.isEmpty() && st.peek().val <= price){
        st.pop();
       }

       int ans = idx - (st.isEmpty() ? -1 : st.peek().index);

       st.push(new Pair(price, idx));

       return ans;
    }
}