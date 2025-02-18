/*
Greedy Approach: try to satisfy greed with closer value of cookie inorder to satisfy more children
T.C -> nlogn + mlogm + m
S - o(1)
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length, n = s.length; 
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r = 0;
        while(l < m && r < n){
            if(s[r] >= g[l]){
                l++;
            }
            r++;
        }

        return l;
    }
}