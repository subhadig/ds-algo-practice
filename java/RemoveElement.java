// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/

// O(n)
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = -1, fast = 0;
        
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        
        return ++slow;
    }
}
