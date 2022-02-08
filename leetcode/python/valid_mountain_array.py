# https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/

# O(n)
class Solution:
    def validMountainArray(self, A: List[int]) -> bool:
        if len(A) < 3:
            return False
        inc = True
        prev = -1
        for i in range(len(A)):
            if prev != -1:
                if A[i] == prev:
                    return False
                elif A[i] < prev:
                    if i <= 1:
                        return False
                    elif inc:
                        inc = False
                elif not inc:
                    return False
            prev = A[i]
        return not inc
