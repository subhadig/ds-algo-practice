// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/

// In progres, failing for input: "mississippi", "issip"
class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)) {
            return 0;
        }
        
        int index = -1, ni = 0;
        boolean matchstart = false;
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(ni)) {
                if(ni == 0) {
                    index = i;
                }
                ni++;
                if(ni == needle.length()) {
                    return index;
                }
                matchstart = true;
            } else {
                ni = 0;
                index = -1;
                matchstart = false;
            }
        }
        
        return -1;
    }
}
