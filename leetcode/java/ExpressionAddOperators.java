// https://leetcode.com/problems/expression-add-operators/

// Failing for input: "105" 5

class Solution {
    
    List<String> result = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) {
            return result;
        }
        
        helper(num.toCharArray(), 0, null, 0, '+', 0, 0, target );
        
        return result;
    }
    
    void helper(char[] nums, int i, String exp, int lastDigit, char lastOp, int lastTotal, int total, int target ) {
        if(i == nums.length) {
            System.out.println(String.format("exp: %s, total: %s", exp, total));
            if(total == target) {
                result.add(exp);
            }
            return;
        }
        
        int next = Character.getNumericValue(nums[i]);
        
        if(exp == null) {
            exp = String.valueOf(next);
            total = next;
            helper(nums, ++i, exp, next, '+', 0, total, target);
        } else {
            i++;
            helper(nums, i, exp + "+" + next, next, '+', total, total + next, target);
            helper(nums, i, exp + "-" + next, next, '-', total, total - next, target);
            
            int newTotal;
            if(lastOp == '+') {
                newTotal = lastTotal + lastDigit * next;
            } else if(lastOp == '-') {
                newTotal = lastTotal - lastDigit * next;
            } else {
                newTotal = lastTotal * lastDigit * next;
            }
            helper(nums, i, exp + "*" + next, next, '*', total, newTotal, target);
        }
    }
}
