# https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/

# O(n)
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = -1
        j = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                if i < j - 1:
                    i += 1
                    nums[i] = nums[j]
                else:
                    i += 1
        i += 1
        while i < len(nums):
            nums[i] = 0
            i += 1
