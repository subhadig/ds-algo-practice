/*

Given two strings, find the longest string that is a substring of both strings.

Input: X = "ABABC", Y = "BABCA"
Output: "BABC"
Explanation: The longest common substring of strings "ABABC" and "BABCA" is "BABC" having length 4. The other common substrings are "ABC", "A", "AB", "B", "BA", "BC", and "C".

*/

class LongestCommonSubstring
{

	public static String findLongestCommonSubstring(String X, String Y, int m, int n)
	{
        if(X.charAt(m - 1) == Y.charAt(n - 1)) {
            return findLongestCommonSubstring(X, Y, m - 1, n - 1) + 1;
        } else {
        }
	}

	public static String findLongestCommonSubstring(String X, String Y)
	{
        findLongestCommonSubstring(X, Y, X.length(), Y.length());
	}

    public static void main(String[] args) {
        findLongestCommonSubstring("ABABC", "BABCA")
    }
}

