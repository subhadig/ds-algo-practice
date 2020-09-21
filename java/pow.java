// https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/

// O(n)
class Solution {
    public double myPow(double x, int n) {
        double output = 0.0;
        if(n == 0) {
            output = 1;
        } else if(n > 0) {
            output = myPow(x, n/2);
            if(n % 2 == 0) {
                output = output * output;
            } else {
                output = x * output * output;
            }
        } else {
            output = 1 / (x * myPow(x, -n - 1));
        }
        return output;
    }
}
