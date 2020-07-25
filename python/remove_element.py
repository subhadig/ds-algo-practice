# https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/

# O(n)
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        head = 0
        tail = len(nums) - 1
        
        while head <= tail:
            if nums[tail] == val:
                tail -= 1
                continue
            if nums[head] == val:
                x = nums[head]
                nums[head] = nums[tail]
                nums[tail] = x
                tail -= 1
            head += 1
        return tail + 1
