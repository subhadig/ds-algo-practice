// https://leetcode.com/problems/restore-ip-addresses

class Solution {
    
    Set<String> result = new HashSet<>();
    String s;
    
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        
        helper(0, null, 0);
            
        return new ArrayList<>(result);
    }
    
    void helper(int start, String exp, int dotCnt) {
        //System.out.println(String.format("exp: %s, start: %s", exp, start));
        
        if(start == s.length() && dotCnt == 3) {
            result.add(exp);
            return;
        }
        
        if(dotCnt >= 3) {
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            int d = Integer.valueOf(str);
            if(str.length() == 1 && d >= 0 && d < 10 
              || str.length() == 2 && d >= 10 && d < 100
              || str.length() == 3 && d >= 100 && d < 256) {
                if(exp == null) {
                    helper(i, str, dotCnt);
                } else {
                    helper(i, exp + "." + str, dotCnt + 1);
                }
                
            } else {
                break;
            }
        }
    }
}
