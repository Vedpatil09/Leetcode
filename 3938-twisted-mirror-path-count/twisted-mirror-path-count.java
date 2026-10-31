// class Solution {

//     public int uniquePaths(int[][] grid) {
//         return f(grid, 0, 0, 2);
//     }

//     int f(int[][] grid, int i, int j, int dir) {

//         int m = grid.length;
//         int n = grid[0].length;

        
//         if (i >= m || j >= n) {
//             return 0;
//         }

        
//         if (i == m - 1 && j == n - 1) {
//             return 1;
//         }

//         int right = 0;
//         int down = 0;

//         if (grid[i][j] == 0) {

//             right = f(grid, i, j + 1, 0);
//             down = f(grid, i + 1, j, 1);

//         } else {

//             if (dir == 0) {
//                 down = f(grid, i + 1, j, 1);
//             } else {
//                 right = f(grid, i, j + 1, 0);
//             }
//         }

//         return right + down;
//     }
// }
//--------------------406/521 cases now have to add DP--------------

import java.util.*;

class Solution {

    int[][][] dp;

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        return f(grid, 0, 0, 2);
    }

    int f(int[][] grid, int i, int j, int dir) {

        int m = grid.length;
        int n = grid[0].length;

        // Base case: invalid position
        if (i >= m || j >= n) {
            return 0;
        }

        // Base case: destination
        if (i == m-1 && j == n-1) {
            return 1;
        }

        // Already calculated
        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        int ans = 0;

        if (grid[i][j] == 0) {

            // Right
            ans = (ans + f(grid, i, j+1, 0)) % 1_000_000_007;

            // Down
            ans = (ans + f(grid, i+1, j, 1)) % 1_000_000_007;

        } else {

            // Mirror reflection
            if (dir == 0) {
                ans = f(grid, i+1, j, 1);
            } else {
                ans = f(grid, i, j+1, 0);
            }
        }

        return dp[i][j][dir] = ans;
    }
}