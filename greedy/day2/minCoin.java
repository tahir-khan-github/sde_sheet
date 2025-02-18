/*
GreedyApproach : to pick the largest which is close to value
T.C -> o(v)
S -> o(1)
 */
    public int minCoins(int coins[], int sum) {
        int cnt = 0;
        Arrays.sort(coins);
        for(int i = coins.length -1; i >= 0; i--){
            while(sum >= coins[i]){
                cnt++;
                sum -= coins[i];
            }
        }
        
        return sum == 0 ? cnt : -1;
    }