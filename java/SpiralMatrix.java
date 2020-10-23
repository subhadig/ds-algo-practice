//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/

// Failing for input: [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new ArrayList<>(0);
        }
        
        int maxi = matrix.length - 1;
        int maxj = matrix[0].length - 1;
        int l = matrix.length * matrix[0].length;
        int mini = 1, minj = 0;
        int i = 0, j = 0;
        int dir = 0;
        
        List<Integer> result = new ArrayList<>(l);
        
        for(int k = 0; k < l; k++) {
            System.out.println(String.format("i:%s, j:%s", i, j));
            result.add(matrix[i][j]);
            
            if(dir == 0) {
                if(j < maxj) {
                    j++;
                } else {
                    dir = 1;
                    i++;
                    maxj--;
                }
            } else if(dir == 1) {
                if(i < maxi) {
                    i++;
                } else {
                    dir = 2;
                    j--;
                    maxi--;
                }
            } else if(dir == 2) {
                if(j > minj) {
                    j--;
                } else {
                    dir = 3;
                    i--;
                    minj++;
                }
            } else {
                if(i > mini) {
                    i--;
                } else {
                    dir = 1;
                    j++;
                    mini++;
                }
            }
        }
        
        return result;
    }
}
