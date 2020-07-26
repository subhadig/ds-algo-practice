# https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3261/

# time: O(n)
# space: O(n)
class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        prev = -10001
        i = 0
        while i < len(A):
            if abs(prev) < abs(A[i]):
                break
            prev = A[i]
            i += 1
            
        i -= 1    
        j = i
        result = []
        while i >= 0 and j < len(A):
            if abs(A[j]) < abs(A[i]):
                result.append(pow(A[j], 2))
                j += 1
            else:
                result.append(pow(A[i], 2))
                if i == j:
                    j += 1
                i -= 1
                
        while i >= 0:
            result.append(pow(A[i], 2))
            i -= 1
            
        while j < len(A):
            result.append(pow(A[j], 2))
            j += 1
                
        return result
