# https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/

# O(n)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        j = 1
        while j < len(nums):
            if nums[j] == nums[i]:
                j += 1
            elif i == j - 1:
                i += 1
                j += 1
            else:
                i += 1
                nums[i] = nums[j]
                j += 1
                
        return i + 1
