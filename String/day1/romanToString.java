/*
Approach : if next character val is small than current then current val +ve else -ve
T.c -> o(n)
 */

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0 ; i < s.length(); i++){
            char ch1 = s.charAt(i);
            if(i+1 < s.length()  && getVal(ch1) < getVal(s.charAt(i+1))){
                sum -= getVal(ch1);
            }else{
                sum += getVal(ch1);
            }
        }

        return sum;
    }

    public int getVal(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default: return 0;
        }
    }
}