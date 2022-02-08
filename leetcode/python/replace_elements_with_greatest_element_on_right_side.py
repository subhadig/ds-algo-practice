# https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/

# O(n)
class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        max_num = -1
        i = len(arr) - 1
        while i >= 0:
            max_num_next = max(arr[i], max_num)
            arr[i] = max_num
            max_num = max_num_next
            i -= 1
        return arr
