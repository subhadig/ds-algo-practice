// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/

// time: O(n), space: O(1)

class Solution {
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }
    
    private void helper(int i, int j, char[] s) {
        if(i >= j) {
            return;
        }
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        helper(++i, --j, s);
    }
}
