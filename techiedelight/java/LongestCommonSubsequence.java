/*

Given two sequences, find the length of the longest common subsequence (LCS) present in it. The LCS is the longest sequence which can be obtained from the first sequence by deleting some items and from the second sequence by deleting other items.

Input: X = "ABCBDAB", Y = "BDCABA"
Output: 4
Explanation: The LCS are "BDAB", "BCAB", and "BCBA", having length 4.

*/

import java.util.*;

class LongestCommonSubsequence
{
    private static int findLCSLength(String X, String Y, int m, int n,
            Map<String, Integer> lookup) {
        if(m == 0 || n == 0) {
            return 0;
        }

        String lookupKey = String.format("%s:%s", m, n);

        if(!lookup.containsKey(lookupKey)) {

            if(X.charAt(m-1) == Y.charAt(n-1)) {
                lookup.put(lookupKey, findLCSLength(X, Y, m-1, n-1, lookup) +
                        1);
            } else {

                lookup.put(lookupKey, Math.max(findLCSLength(X, Y, m, n-1,
                                lookup), findLCSLength(X, Y, m-1, n, lookup)));
            }
        }
        return lookup.get(lookupKey);
	}
	
	public static int findLCSLength(String X, String Y)
	{
        Map<String, Integer> lookup = new HashMap<>();
		return findLCSLength(X, Y, X.length(), Y.length(), lookup);
	}

    public static void main(String[] args) {
        System.out.println(findLCSLength("ABCBDAB", "BDCABA")); //4
        System.out.println(findLCSLength("abdcbcdbdcbbc", "bdcbbcabdcbcd")); //10
    }
}
