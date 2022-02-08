// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/

class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)) {
            return 0;
        } else if(haystack.length() == needle.length() && !haystack.equals(needle)) {
            return -1;
        }
        
        List<Index> indexes = new ArrayList<>();
        
        for(int i = 0; i < haystack.length(); i++) {
            
            Iterator<Index> itr = indexes.iterator();
            while(itr.hasNext()) {
                Index ind = itr.next();
                if(haystack.charAt(i) == needle.charAt(ind.ni)) {
                    ind.ni++;
                    if(ind.ni == needle.length()) {
                        return ind.hi;
                    }
                } else {
                    itr.remove();
                }
            }
            
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(needle.length() == 1) {
                    return i;
                }
                indexes.add(new Index(i));
            }
        }
        
        for(Index ind : indexes) {
            if(ind.ni == needle.length()) {
                return ind.hi;
            }
        }
        
        return -1;
    }
    
    static class Index {
        int hi = -1;
        int ni = 0;
        
        Index(int hi) {
            this.hi = hi;
            ni++;
        }
    }
}
