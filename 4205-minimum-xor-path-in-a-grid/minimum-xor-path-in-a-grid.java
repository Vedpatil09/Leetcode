// class Solution {
//     int ans = Integer.MAX_VALUE;

//     public int minCost(int[][] grid) {
//         ans = Integer.MAX_VALUE;
//         f(grid, 0, 0, grid[0][0]);
//         return ans;
//     }

//     void f(int[][] grid, int i, int j, int xor) {
//         int m = grid.length;
//         int n = grid[0].length;

//         if (i == m - 1 && j == n - 1) {
//             ans = Math.min(ans, xor);
//             return;
//         }

//         if (j + 1 < n) {
//             f(grid, i, j + 1, xor ^ grid[i][j + 1]);
//         }

//         if (i + 1 < m) {
//             f(grid, i + 1, j, xor ^ grid[i + 1][j]);
//         }
//     }
// }
// ------------830/999 TIme Limie Exceed------------------


class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int x = 0; x < 1024; x++) {
                    if (!dp[i][j][x]) continue;

                    if (i + 1 < m) {
                        dp[i + 1][j][x ^ grid[i + 1][j]] = true;
                    }

                    if (j + 1 < n) {
                        dp[i][j + 1][x ^ grid[i][j + 1]] = true;
                    }
                }
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
