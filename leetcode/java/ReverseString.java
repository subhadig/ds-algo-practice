// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/

// O(n)
class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while(l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
