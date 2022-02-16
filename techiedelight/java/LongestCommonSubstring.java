/*

Given two strings, find the longest string that is a substring of both strings.

Input: X = "ABABC", Y = "BABCA"
Output: "BABC"
Explanation: The longest common substring of strings "ABABC" and "BABCA" is "BABC" having length 4. The other common substrings are "ABC", "A", "AB", "B", "BA", "BC", and "C".

*/

class LongestCommonSubstring
{

	public static String findLongestCommonSubstring(String X, String Y)
	{
        int[][] lookup = new int[X.length()][Y.length()];

        int maxLen = 0;
        int endingInd = 0;

        for(int i = 0; i < X.length(); i++) {
            for(int j = 0; j < Y.length(); j++) {
                if(X.charAt(i) == Y.charAt(j)) {
                    if(i > 0 && j > 0) {
                        lookup[i][j] = lookup[i-1][j-1] + 1;
                    } else {
                        lookup[i][j] = 1;
                    }

                    if(lookup[i][j] > maxLen) {
                        maxLen = lookup[i][j];
                        endingInd = i;
                    }
                }
            }
        }

        return X.substring(endingInd - maxLen + 1, endingInd + 1);
	}

    public static void main(String[] args) {
        System.out.println(findLongestCommonSubstring("ABABC", "BABCA"));
    }
}

