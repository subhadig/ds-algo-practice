// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/

// O(n)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean cons = false;
        int n = 0, N = 0;
        
        for(int i : nums) {
            if(i == 1) {
                n++;
                cons = true;
            } else {
                if(cons) {
                    if(n > N) {
                        N = n;
                    }
                }
                cons = false;
                n = 0;
            }
        }
        
        return N > n ? N : n;
    }
}
