//https://leetcode.com/problems/contains-duplicate-ii/submissions/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer prevInd = numMap.put(nums[i], i);
            if(prevInd != null && (i - prevInd) <= k) {
                return true;
            }
        }
        return false;
    }
}
