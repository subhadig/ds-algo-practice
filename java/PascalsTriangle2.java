// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/

// time: O(nk), space:O(k)

class Solution {
    public List<Integer> getRow(int rowIndex) {
        return helper(new ArrayList<>(), 0, rowIndex);
    }
    
    private List<Integer> helper(List<Integer> row, int i, int rowIndex) {
        int prev = 0;
        for(int j = 0; j < i; j++) {
            int cur = row.get(j);
            row.set(j, prev + cur);
            prev = cur;
        }
        row.add(1);
        
        if(i == rowIndex) {
            return row;
        }
        return helper(row, i+1, rowIndex);
    }
}
