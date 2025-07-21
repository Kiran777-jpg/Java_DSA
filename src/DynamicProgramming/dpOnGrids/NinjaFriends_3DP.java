package DynamicProgramming.dpOnGrids;

public class NinjaFriends_3DP {

    private static int recursion(int i, int j1, int j2, int[][] matrix, int[][][] dp) {
        if (j1 < 0 || j1 >= matrix[0].length || j2 < 0 || j2 >= matrix[0].length)
            return (int) (Math.pow(-10, 9));
        if(i==matrix.length-1) {
            if(j1==j2)
                return dp[i][j1][j2]=matrix[i][j1];
            return dp[i][j1][j2]=matrix[i][j1]+matrix[i][j2];
        };

        int maxi=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++) {
            for(int dj2=-1;dj2<=1;dj2++) {
                int ans;
                if(j1==j2)
                    ans=matrix[i][j1]+recursion(i+1, j1+dj1, j2+dj2, matrix, dp);
                else
                    ans=matrix[i][j1]+matrix[i][j2]+recursion(i+1, j1+dj1, j2+dj2, matrix, dp);
                maxi=Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2]=maxi;
    }

    private static void memoization(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int[][][] dp=new int[n][m][m];
        int ans=recursion(0, 0, m-1, matrix,dp);
        System.out.println(ans);
    }

    private static void tabulation(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = matrix[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = matrix[i][j1];
                            else
                                ans = matrix[i][j1] + matrix[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        System.out.println(dp[0][0][m - 1]);
    }

    static void spaceOptimzation(int[][] grid) {
        int n= grid.length, m=grid[0].length;
        // Create two 2D arrays to store computed results: front and cur
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Initialize the front array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the cur array
                    cur[j1][j2] = maxi;
                }
            }

            // Update the front array with the values from the cur array for the next row
            for (int a = 0; a < m; a++) {
                front[a] = cur[a].clone();
            }
        }

        // The final result is stored at the top left corner of the front array
        System.out.println(front[0][m - 1]);
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        memoization(matrix);   // TC: O(N*M*M) * 9, SC: O(N)+O(N*M*M)
        tabulation(matrix);    // TC: O(N*M*M)*9, SC: O(N*M*M)
        spaceOptimzation(matrix);  // TC: O(N*M*M)*9, SC: O(M*M)
    }
}
