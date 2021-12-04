//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer index = numMap.get(target - nums[i]);
            if(index == null) {
                numMap.put(nums[i], i);
            } else {
                return new int[]{index, i};
            }
        }
        return null;
    }
}
