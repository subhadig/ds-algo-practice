# https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/

class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        even_cnt = 0
        for num in nums:
            if self.getCount(num) % 2 == 0:
                even_cnt += 1
        
        return even_cnt
            
    def getCount(self, num):
        cnt = 1
        while num >= 10:
            num = num / 10
            cnt += 1
        else:            
            return cnt
