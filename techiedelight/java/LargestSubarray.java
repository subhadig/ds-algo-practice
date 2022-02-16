/*

Given a binary array containing 0's and 1's, find the largest contiguous subarray with equal numbers of 0's and 1's.

Input : [0, 0, 1, 0, 1, 0, 0]
Output: [0, 1, 0, 1] or [1, 0, 1, 0]

Input : [0, 0, 0, 0]
Output: []

Note: Since an input can contain several largest subarrays with equal numbers of 0's and 1's, the code should return any one of them.

*/

import java.util.*;

class LargestSubarray
{
	public static List<Integer> findLargestSubarray(List<Integer> nums)
	{
		List<Integer> largestSubarray = new ArrayList<>();
        int maxLen = 0;
        int endingInd = -1;

        for(int i = 0; i < nums.size(); i++) {

            int zeros = 0;
            int ones = 0;

            for(int j = i; j < nums.size(); j++) {
                if(nums.get(j) == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if(zeros == ones) {
                    if(j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        endingInd = j;
                    }
                }
            }
            zeros = 0;
            ones = 0;
        }

        for(int i = endingInd - maxLen + 1; i <= endingInd; i++) {
            largestSubarray.add(nums.get(i));
        }

		return largestSubarray;
	}

    public static void main(String[] args) {
        System.out.println(findLargestSubarray(Arrays.asList(0, 0, 1, 0, 1, 0, 0)));
        System.out.println(findLargestSubarray(Arrays.asList(0, 0, 0, 0)));
    }
}

