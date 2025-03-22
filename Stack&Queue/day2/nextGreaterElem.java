/*
Brute: use 2 loops to find NGE
T.C -> n^2 for NGE
S -> 1
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length];

        for(int i = 0; i<nums1.length; i++){
            arr[i] = -1;

            //finding NGE
            for(int j = 0 ; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    for(int k = j + 1; k < nums2.length; k++){
                        if(nums2[k] > nums2[j]){
                            arr[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return arr;
    }
}

/*
Approach: traverse from back and use stack
T.C -> operational (2n)
S -> n

 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        int nge[] = helper(nums2);

        for(int i = 0; i<nums1.length; i++){
        
            for(int j = 0 ; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = nge[j];
                    break;
                }
            }
        }

        return ans;
    }

    public int[] helper(int arr[]){
        int nge[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length - 1 ; i>= 0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return nge;
    }
}