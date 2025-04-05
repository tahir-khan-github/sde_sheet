/*
Appraoch: integer -> roman , select largest number that can cover num and then add symbol based on times and reduce number
T.C -> o(n)
S-> 2n
 */

class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < values.length; i++){
            if(num == 0) break;

           int times = num/values[i];
           while(times > 0){
            sb.append(symbols[i]);
            times--;
           }
           num = num % values[i];
        }

        return sb.toString();
    }
}