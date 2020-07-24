# https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_seq = 0
        cur_seq = 0
        for num in nums:
            if num == 1:
                cur_seq += 1
            else:
                if cur_seq > max_seq:
                    max_seq = cur_seq
                cur_seq = 0
        
        return max(cur_seq, max_seq)
