/*
Approach:move based on start and end with currsize to handle edge cases, also movement will be circular
T.C -> o(1)
S -> o(1)
 */
{
    	void push(int x)
	{
	   if(currSize == 0){
	       start = 0, end = 0;
	   }else{
	       end = (end+1)%size;
	   }
	   
	   arr[end] = x;
	   currSize++;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		if(currSize == 0) return -1;
		int x = arr[start];
		if(currSize == 1){
		    start = -1, end = -1;
		}else{
		    start = (start+1)/size;
		}
		currSize--;+
		
		return x;
	}
}