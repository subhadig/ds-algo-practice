// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/


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

// In progress
class Solution {
    public int kthGrammar(int N, int K) {
        List<Integer> origins = getOrigins(new ArrayList<>(), K);
        System.out.println(origins);
        
        int val = 1;
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
    
    List<Integer> getOrigins(List<Integer> origins, int K) {
        int prevK = K / 2;
        origins.add(K % 2);
        if(prevK == 0) {
            return origins;
        } else {
            return getOrigins(origins, prevK);
        }
    }
}
