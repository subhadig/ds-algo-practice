// https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/

// O(n)
class Solution {
    public int dominantIndex(int[] nums) {
        int largest = 0;
        int largestInd = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largest) {
                largest = nums[i];
                largestInd = i;
            }
        }
        
        for(int num : nums) {
            if(largest != num && largest < 2 * num) {
                return -1;
            }
        }
        return largestInd;
    }
}
