// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/

// non-recursive
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> prow = null;
        for(int i = 1; i <= numRows; i++) {
            prow = helper(i, prow);
            result.add(prow);
        }
        
        return result;
    }
    
    List<Integer> helper(int n, List<Integer> prow) {
        List<Integer> row = new ArrayList<>();
        
        row.add(1);
        
        for(int i = 2; i < n; i++) {
            row.add(prow.get(i - 2) + prow.get(i - 1));
        }
        
        if(row.size() < n) {
            row.add(1);
        }
        
        return row;
    }
}

// recursive
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows == 0) {
            return result;
        }
        
        helper(numRows, 1, null, result);
        
        return result;
    }
    
    void helper(int numRows, int n, List<Integer> prow, List<List<Integer>> result) {
        List<Integer> row = new ArrayList<>();
        
        row.add(1);
        
        for(int i = 2; i < n; i++) {
            row.add(prow.get(i - 2) + prow.get(i - 1));
        }
        
        if(row.size() < n) {
            row.add(1);
        }
        
        result.add(row);
        
        if(n != numRows) {
            helper(numRows, ++n, row, result);
        }
    }
}
