# https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/

class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        num_of_0 = 0
        last_i = 0
        for i in range(len(arr)):
            if num_of_0 + i >= len(arr):
                last_i = i - 1
                break
            if arr[i] == 0:
                num_of_0 += 1
                
        if num_of_0 == 0:
            return
                
        i = last_i
        j = len(arr) - 1
        
        print(f"last_i:{last_i}, num_of_0:{num_of_0}, i:{i}, j:{j}")
        
        while i >= 0:
            arr[j] = arr[i]
            j -= 1
            if arr[i] == 0:
                arr[j] = 0
                j -= 1
            i -= 1
                
