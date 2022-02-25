/*

Given a rod of length n, find the optimal way to cut the rod into smaller rods to maximize the product of each of the smaller rod's price. Assume that each rod of length i has price i.

Input: n = 4 (rod length)
Output: 4
Explanation: Cut the rod into two pieces of length 2 each to gain revenue of 2×2 = 4

Cut				Profit
4				4
1, 3			(1 × 3) = 3
2, 2			(2 × 2) = 4	  <-- optimal way
3, 1			(3 × 1) = 3
1, 1, 2			(1 × 1 × 2) = 2
1, 2, 1			(1 × 2 × 1) = 2
2, 1, 1			(2 × 1 × 1) = 2
1, 1, 1, 1		(1 × 1 × 1 × 1) = 1

Similarly, for n = 6, (3 × 3) = 9
For n = 8, (2 × 3 × 3) = 18
For n = 15, (3 × 3 × 3 × 3 × 3) = 243

*/

class RodCuttingII
{
	public static long findMaxProfit(int n)
	{
        int[] lookup = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                lookup[i] = Math.max(lookup[i], lookup[i - j] * (j + 1));
            }
        }
	}

    public static void main(String[] args) {
        System.out.println("Max profit: " + findMaxProfit(4));
    }
}
