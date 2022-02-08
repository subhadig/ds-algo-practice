// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/

// O(n)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        
        boolean dir = true;
        int i = 0, j = 0;
        
        for(int x = 0; x < result.length; x++) {
            result[x] = matrix[i][j];
            
            if(dir) {
                if(i > 0 && j < n - 1) {
                    i--;
                    j++;
                } else if(j < n - 1) {
                    dir = !dir;
                    j++;
                } else {
                    dir = !dir;
                    i++;
                }
            } else {
                if(i < m - 1 && j > 0) {
                    i++;
                    j--;
                } else if(i < m - 1) {
                    dir = !dir;
                    i++;
                } else {
                    dir = !dir;
                    j++;
                }
            }            
        }
        
        return result;
    }
}
