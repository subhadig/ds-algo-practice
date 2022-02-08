# https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/

# O(n)
class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        i = 0
        j = len(A) - 1
        while i < j:
            if A[i] % 2 == 0:
                i += 1
            elif A[j] % 2 != 0:
                j -= 1
            else:
                A[i], A[j] = A[j], A[i]
                i += 1
                j -= 1
        return A
