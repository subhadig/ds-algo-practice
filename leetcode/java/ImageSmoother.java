// https://leetcode.com/problems/image-smoother/

class Solution {
    public int[][] imageSmoother(int[][] M) {
        
        int[][] N = new int[M.length][M[0].length];
        
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[i].length; j++) {
                N[i][j] = getAvg(M, i, j);
            }
        }
        
        return N;
    }
    
    int getAvg(int[][] M, int i, int j) {
        int count = 0;
        int sum = 0;
        
        int minI = i - 1 < 0 ? 0 : i - 1;
        int maxI = i + 1 >= M.length ? M.length - 1 : i + 1;
        
        int minJ = j - 1 < 0 ? 0 : j - 1;
        int maxJ = j + 1 >= M[i].length ? M[i].length - 1 : j + 1;
        
        for(int k = minI; k <= maxI; k++) {
            for(int l = minJ; l <= maxJ; l++) {
                count++;
                sum += M[k][l];
            }
        }
        
        return sum/count;
    }
}
