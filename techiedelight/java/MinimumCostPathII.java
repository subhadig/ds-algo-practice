/*

Given an `N x N` matrix of non-negative integers, where each cell of the matrix (i, j) indicates the direct flight cost from the city `i` to city `j`. The task is to find the minimum cost to reach the destination city `N-1` from the source city 0.


Input:

mat = [
	[0,   20, 30, 100],
	[20,  0,  15, 75 ],
	[30,  15, 0,  50 ],
	[100, 75, 50, 0  ]
]

Output: 80

Explanation: The minimum cost is 80 and the minimum cost path is:

city 0 -> city 2 (cost = 30)
city 2 -> city 3 (cost = 50)


Input:

mat = [
	[0,  25, 20, 10, 105],
	[20, 0,  15, 80, 80 ],
	[30, 15, 0,  70, 90 ],
	[10, 10, 50, 0,  100],
	[40, 50, 5,  10, 0  ]
]

Output: 100

Explanation: The minimum cost is 100 and the minimum cost path is:

city 0 -> city 3 (cost = 10)
city 3 -> city 1 (cost = 10)
city 1 -> city 4 (cost = 80)

*/

class MinimumCostPathII
{
	public static int findMinCost(int[][] cost)
	{
        int[] lookup = new int[cost.length];

        for(int i = 0; i < cost.length; i++) {
            lookup[i] = cost[0][i];
        }

        boolean isUpdated = true;

        while(isUpdated) {
            isUpdated = false;

            for(int i = 0; i < cost.length; i++) {

                for(int j = 0; j < cost[i].length; j++) {

                    if(lookup[i] > lookup[j] + cost[j][i]) {
                        lookup[i] = lookup[j] + cost[j][i]; //cost[j][i] because cost of travelling from Cj to Ci
                        isUpdated = true;
                    }
                }
            }
        }
        return lookup[cost.length - 1];
	}
    
    public static void main(String[] args) {
        int[][] cost = new int[][] {
            {0,   20, 30, 100},
            {20,  0,  15, 75 },
            {30,  15, 0,  50 },
            {100, 75, 50, 0  }
        };
        System.out.println(findMinCost(cost));

        cost = new int[][] {
            {0,  25, 20, 10, 105},
            {20, 0,  15, 80, 80 },
            {30, 15, 0,  70, 90 },
            {10, 10, 50, 0,  100},
            {40, 50, 5,  10, 0  }
        };
        System.out.println(findMinCost(cost));
    }
}

