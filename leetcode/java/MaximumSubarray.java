//https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int prevSum = Integer.MIN_VALUE;
        for(int num: nums) {
            sum = sum + num;
            if(sum > prevSum) {
                prevSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return prevSum;
    }
}
