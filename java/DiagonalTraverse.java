// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/

// In progress
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        boolean leftToRight = true;
        
        while(true) {
            System.out.println("i,j = " + i + "," + j);
            if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length) {
                
                result.add(matrix[i][j]);
                
                if(i == matrix.length - 1 && j == matrix[i].length - 1) {
                    break;
                }
            } else {
               leftToRight = !leftToRight; 
            }
            
            if(leftToRight) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
        }
        
        int[] output = new int[result.size()];
        for(int k = 0; k < output.length; k++) {
            output[k] = result.get(k);
        }
        return output;
    }
}
