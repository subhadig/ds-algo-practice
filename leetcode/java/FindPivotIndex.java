// https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/

// O(n)
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum = sum + num;
        }
        
        int lsum = 0, rsum = sum;
        for(int i = 0; i < nums.length; i++) {
            rsum = rsum - nums[i];
            if(lsum == rsum) {
                return i;
            }
            lsum = lsum + nums[i];
        }
        return -1;
    }
}
