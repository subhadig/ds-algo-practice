// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/

// O(n)
class Solution {
    public int kthGrammar(int N, int K) {
        List<Integer> origins = getOrigins(new ArrayList<>(), N, K);
        
        int val = 0;
        for(int i = origins.size() - 1; i >= 0; i--) {
            if(origins.get(i) == 0) {
                if(val == 0) {
                    val = 0;
                } else {
                    val = 1;
                }
            } else {
                if(val == 0) {
                    val = 1;
                } else {
                    val = 0;
                }
            }
        }
        
        return val;
    }
    
    List<Integer> getOrigins(List<Integer> origins, int N, int K) {
        
        int prevK;
        
        if(K % 2 == 1) {
            prevK = K / 2 + 1;
            origins.add(0);
        } else {
            prevK = K / 2;
            origins.add(1);
        }
        
        if(N == 1) {
            return origins;
        } else {
            return getOrigins(origins, N - 1, prevK);
        }
    }
}


// Memory limit exceeded
class Solution {
    public int kthGrammar(int N, int K) {
        List<Integer> NthRow = getNthRow(1, N, null);
        return NthRow.get(K - 1);
    }
    
    List<Integer> getNthRow(int n, int N, List<Integer> row) {
        List<Integer> newRow = new ArrayList<>();
        
        if(n == 1) {
            newRow.add(0);
        } else {
           for(int e : row) {
               if(e == 0) {
                   newRow.add(0);
                   newRow.add(1);
               } else {
                   newRow.add(1);
                   newRow.add(0);
               }
           }
        }
        
        if(n == N) {
            return newRow;
        } else {
            return getNthRow(n + 1, N, newRow);
        }
    }
}
