/*
Brute: sort both string and compare
 */

//str.split("").sort().join('') -> s.equals(t)

/*
Better: store all char of s int freq map and increase freq, then check for t char and reduce freq map freq, after that check for map val
if any non zero then its not anagra
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int count[] = new int[128];

        for(char ch: s.toCharArray()){
           count[ch-'a']++;
        }

          for(char ch: t.toCharArray()){
           count[ch-'a']--;
        }

        for(int val: count){
            if(val != 0) return false;
        }

        return true;
    }
}