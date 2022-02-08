// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/

// time: O(nk), space:O(k)
class Solution {
    
    List<Integer> result;
    
    public List<Integer> getRow(int rowIndex) {
        result = new ArrayList<>(rowIndex);
        
        helper(0, rowIndex);
        
        return result;
    }
    
    void helper(int i, int n) {
        if(i > 1) {
            int pre = 0;

            for(int j = 0; j < i; j++) {
                int nPre = result.get(j);
                result.set(j, pre + result.get(j));
                pre = nPre;
            }
        }
        
        result.add(1);
        
        if(i != n) {
            helper(++i, n);
        }
    }
}

// time: O(nk)
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
