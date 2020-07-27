// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/

// O(n)
class Solution {
    public int thirdMax(int[] nums) {
        long[] maxNums = new long[3];

        for(int i = 0; i < 3; i++) {
            maxNums[i] = Long.MIN_VALUE;
        }
        
        for(int num : nums) {
            if(contains(maxNums, num)) {
                continue;
            } else if(num > maxNums[0]) {
                maxNums[2] = maxNums[1];
                maxNums[1] = maxNums[0];
                maxNums[0] = num;
            } else if(num > maxNums[1]) {
                maxNums[2] = maxNums[1];
                maxNums[1] = num;
            } else if(num > maxNums[2]) {
                maxNums[2] = num;
            }
        }
        
        if(maxNums[2] > Long.MIN_VALUE) {
            return (int)maxNums[2];
        } else {
            return (int)maxNums[0];
        }
    }
    
    private static boolean contains(long[] arr, int val) {
        for(long item : arr) {
            if(val == item) {
                return true;
            }
        }
        return false;
    }
}
