/*

Given an `M x N` matrix of integers where each cell has a cost associated with it, find the minimum cost to reach the last cell (M-1, N-1) of the matrix from its first cell (0, 0). You can only move one unit right or one unit down from any cell, i.e., from cell (i, j), you can move to (i, j+1) or (i+1, j).

Input:

[
	[4, 7, 8, 6, 4],
	[6, 7, 3, 9, 2],
	[3, 8, 1, 2, 4],
	[7, 1, 7, 3, 7],
	[2, 9, 8, 9, 3]
]

Output: 36

Explanation: The highlighted path shows the minimum cost path having a cost of 36.

	4   7   8   6   4
	|
	6 - 7 - 3   9   2
			|
	3   8   1 - 2   4
				|
	7   1   7   3 - 7
					|
	2   9   8   9   3

*/

class MinimumCostPath
{
	public static int findMinCost(int[][] cost)
	{
        int m = cost.length;
        int n = cost[0].length;
        int[][] lookup = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    lookup[i][j] = cost[i][j];
                } else if(i == 0) {
                    lookup[i][j] = lookup[i][j - 1] + cost[i][j];
                } else if(j == 0) {
                    lookup[i][j] = lookup[i - 1][j] + cost[i][j];
                } else {
                    lookup[i][j] = cost[i][j] + Math.min(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }

        printLookup(lookup);

        return lookup[m - 1][n - 1];
	}

    private static void printLookup(int[][] lookup) {
        for(int i = 0; i < lookup.length; i++) {
            for(int j = 0; j < lookup[i].length; j++) {
                System.out.print(lookup[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] cost = new int[][] {
           {4, 7, 8, 6, 4},
           {6, 7, 3, 9, 2},
           {3, 8, 1, 2, 4},
           {7, 1, 7, 3, 7},
           {2, 9, 8, 9, 3}
        };
        System.out.println("Minimum cost: " + findMinCost(cost));
    }
}

