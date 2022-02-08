# https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/

# O(n^2)
class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        i = 0
        while i < len(arr):
            if arr[i] == 0 and i + 1 < len(arr):
                self.shift(arr, i+1)
                arr[i+1] = 0
                i += 1
            i += 1
            
    def shift(self, arr, n):
        i = len(arr) - 1
        while i > n:
            arr[i] = arr[i - 1]
            i -= 1

# O(n)
class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        num_of_0 = 0
        i = 0
        while i + num_of_0 < len(arr):
            if arr[i] == 0:
                num_of_0 += 1
            i += 1
        i -= 1
            
        while i >= 0:
            if arr[i] == 0:
                if i + num_of_0 < len(arr):
                    arr[i + num_of_0] = 0
                num_of_0 -= 1
                arr[i + num_of_0] = 0
            else:
                arr[i + num_of_0] = arr[i]
            i -= 1

