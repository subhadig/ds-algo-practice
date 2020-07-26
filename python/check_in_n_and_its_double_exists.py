# https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/

# time: O(n)
# space: O(n)
class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        if not arr:
            return False
        nums = set()
        for x in arr:
            if 2*x in nums or x/2 in nums:
                return True
            else:
                nums.add(x)
        return False
