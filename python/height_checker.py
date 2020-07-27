# https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/

# O(nlogn)
class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        sorted_heights = sorted(heights)
        min_change = 0
        for i in range(len(heights)):
            if heights[i] != sorted_heights[i]:
                min_change += 1
                
        return min_change
