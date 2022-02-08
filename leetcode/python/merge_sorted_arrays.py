# https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        while i >= 0 and j >= 0:
            a = nums1[i]
            b = nums2[j]
            if a > b:
                nums1[i + j + 1] = a
                i -= 1
            else:
                nums1[i + j + 1] = b
                j -= 1
                
        while j >= 0:
            nums1[j] = nums2[j]
            j -= 1
