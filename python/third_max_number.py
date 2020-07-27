# https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/

# O(n)
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        max_arr = [-2147483649, -2147483649, -2147483649]
        for num in nums:
            if num in max_arr:
                continue
            elif num > max_arr[0]:
                max_arr[0], max_arr[1], max_arr[2] = num, max_arr[0], max_arr[1]
            elif num > max_arr[1]:
                max_arr[1], max_arr[2] = num, max_arr[1]
            elif num > max_arr[2]:
                max_arr[2] = num
                
        if max_arr[2] == -2147483649:
            return max_arr[0]
        return max_arr[2]

