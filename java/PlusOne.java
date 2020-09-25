// https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/

// O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int newDigit;
            if(i == digits.length - 1) {
                newDigit = digits[i] + 1;
            } else if(carry != 0) {
                newDigit = digits[i] + carry;
            } else {
                break;
            }
            
            digits[i] = newDigit % 10;
            carry = newDigit / 10;
        }
        
        if(carry != 0) {
            int[] output = new int[digits.length + 1];
            output[0] = carry;
            
            int i = 1, j = 0;
            while(i < output.length) {
                output[i++] = digits[j++];
            }
            
            return output;
        } else {
            return digits;
        }
    }
}
