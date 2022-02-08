# https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/

class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        lowest_el_ind = -1
        lowest_el = 10001
        for i in range(len(A)):
            abs_val = abs(A[i])
            if abs_val < lowest_el:
                lowest_el_ind = i
                lowest_el = abs_val

        if lowest_el_ind == 0:
            return [ x*x for x in A ]
        
        i = lowest_el_ind
        j = lowest_el_ind + 1
        final_list = []
        while i >= 0 and j < len(A):
            if A[j] < abs(A[i]):
                final_list.append(pow(A[j], 2))
                j += 1
            else:
                final_list.append(pow(A[i], 2))
                i -= 1
        else:
            while i >= 0:
                final_list.append(pow(A[i], 2))
                i -= 1
            else:
                while j < len(A):
                    final_list.append(pow(A[j], 2))
                    j += 1
                    
        return final_list
