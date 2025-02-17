// find pow(x, n) -> x^n

/*
Brute: loop till power and mutiply ans along with handling 2 edge cases 1) when n == 0, when n == -ve
 */
{
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }
        double result = 1.0;
        for(int i = 0 ;i < exp; i++){
            result *= x;
        }
        return result;
    }
}

/*
optimal: use power odd and even formula along with 2 edge cases
power is even (x = x*x, pow/2), when power is odd (ans = ans * x, pow -1) 
 */
{
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }

        double result = 1.0;

        while(exp > 0){
            if(exp % 2 == 0){
                x = x*x;
                exp = exp/2;
            }else{
                result = result * x;
                exp = exp -1;
            }
        }

        return result;
    }
}