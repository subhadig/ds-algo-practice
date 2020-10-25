// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while(i >= 0 && j >= 0) {
            char s;
            int nc = 0;
            
            if(a.charAt(i) == '0' && b.charAt(j) == '0') {
                s = '0';
            } else if(a.charAt(i) == '1' && b.charAt(j) == '0'
                      || a.charAt(i) == '0' && b.charAt(j) == '1') {
                s = '1';
            } else {
                s = '0';
                nc = 1;
            }
            
            if(c == 1) {
                if(s == '0') {
                    s = '1';
                } else {
                    s = '0';
                    nc = 1;
                }
            }
            
            result.append(s);
            c = nc;
            i--;
            j--;
        }
        
        while(i >= 0) {
            char s = a.charAt(i);
            
            if(c == 1) {
                if(s == '0') {
                    s = '1';
                    c = 0;
                } else {
                    s = '0';
                }
            }
            result.append(s);
            i--;
        }
        
        while(j >= 0) {
            char s = b.charAt(j);
            
            if(c == 1) {
                if(s == '0') {
                    s = '1';
                    c = 0;
                } else {
                    s = '0';
                }
            }
            result.append(s);
            j--;
        }
        
        if(c == 1) {
            result.append('1');
        }
        
        return result.reverse().toString();
    }
}
