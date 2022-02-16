/*

Given an integer array, find the maximum length contiguous subarray having a given sum.

Input : nums[] = [5, 6, -5, 5, 3, 5, 3, -2, 0], target = 8
Output: [-5, 5, 3, 5]
Explanation: The subarrays with sum 8 are [[-5, 5, 3, 5], [3, 5], [5, 3]]. The longest subarray is [-5, 5, 3, 5] having length 4.

Note: Since an input can contain several maximum length subarrays with given sum, the solution should return any one of the maximum length subarray.

*/
import java.util.*;

class MaximumLengthSubarray
{
	public static List<Integer> findMaxLenSubarray(List<Integer> nums, int target)
	{
        int maxLen = 0;
        int endingInd = 0;

        for(int i = 0; i < nums.size(); i++) {
            int sum = nums.get(i);
            for(int j = i + 1; j < nums.size(); j++) {
                sum += nums.get(j);
                if(sum == target) {
                    if(j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        endingInd = j;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = endingInd - maxLen + 1; i <= endingInd; i++) {
            result.add(nums.get(i));
        }
        return result;
	}

    public static void main(String[] args) {
        System.out.println(findMaxLenSubarray(Arrays.asList(5, 6, -5, 5, 3, 5, 3, -2, 0), 8));
    }
}
