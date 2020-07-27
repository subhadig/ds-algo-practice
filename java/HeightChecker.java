// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/

// O(nlogn)
class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);
            
        int minChange = 0;
        
        for(int i = 0; i < heights.length; i++) {
            if(sortedHeights[i] != heights[i]) {
                minChange++;
            }
        }
        
        return minChange;
    }
}
