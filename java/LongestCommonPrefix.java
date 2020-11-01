// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        
        StringBuilder prefix = new StringBuilder();
        
        int i = 0;
        boolean isBreak = false;
        while(!isBreak) {
            boolean match = true;
            Character c = null;
            for(String str : strs) {
                if(i >= str.length()) {
                    match = false;
                    isBreak = true;
                    break;
                } else if(c == null) {
                    c = str.charAt(i);
                } else if(c != str.charAt(i)) {
                    match = false;
                    isBreak = true;
                    break;
                }
                
                if(i == str.length() - 1) {
                    isBreak = true;
                }
            }
            
            if(match) {
                prefix.append(c);
            }
            i++;
        }
        
        return prefix.toString();
    }
}
