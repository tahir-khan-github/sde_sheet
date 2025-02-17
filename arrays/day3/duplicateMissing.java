//find duplicate and missing number 
 /*
 Brute:- we use repeat and missing and use 2 iteration 1st iteration is for choosing numbers from 1 to n and second iteration is for 
 comparing (arr[j] == i) if that matches means duplicate found count will be more than 2 and if count is 0 for any number(i) means it 
 missing one
 T.C -> O(n^2)
  */
 {
    public int[] repeatedNumber(int[] A) {
        int ans[] = new int[2];
        int repeat = - 1, missing = -1;
        for(int i = 1; i<= A.length; i++){
            int count = 0;
            for(int j = 0 ; j< A.length; j++){
                if(A[j] == i){
                    count++;
                }
            }
            if(count == 2) repeat = i;
            if(count == 0) missing = i;
            if(repeat != -1 && missing != -1) break;
        }
        
        ans[0] = repeat;
        ans[1] = missing;
        return ans;
    }
 }

 /*
 Better -> whenever there is counting we use hashing/ frequency 
 we maintaing frequency and the iterate one more time to check which has 2(repeat) and which has 0(missing) 
 T.C -> o(n) + O(n) = o(2n) `= o(n)
  */
 {
    public int[] repeatedNumber(int[] A) {
       
        int freq[] = new int[A.length+1];
        int repeat = - 1, missing = -1;
        for(int i = 0; i< A.length; i++){
           freq[A[i]]++;
        }
        
         for(int i = 1; i< A.length; i++){
             if(freq[i] == 2) repeat = i;
             else if(freq[i] == 0) missing = i;
             if(repeat != -1 && missing != -1) break;
        }
        

        return new int[]{repeat, missing};
    }
}

/*
optimal approach:-(using maths)
s - sn, s2 - s2n make equation and find value of x and y
T.C -> O(n)
 */
 {
    public int[] repeatedNumber(int[] A) {
        long n = A.length;
        //s -sn
        //s2 - s2n
        long s=0, s2 = 0;
        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        
        for(int i = 0 ; i < n ; i++){
            s += A[i];
            s2 += (long)A[i] * A[i]; 
        }
        long val1 = s - sn; // (x - y);
        long val2 = s2 - s2n;
        val2 = val2/val1; //(x+y)
        
       long x = (val1 + val2)/2;
       long y = val2 - x;
     
        

        return new int[]{(int)x, (int)y};
    }
}
