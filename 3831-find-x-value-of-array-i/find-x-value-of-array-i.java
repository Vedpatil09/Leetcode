// class Solution {
//     public long[] resultArray(int[] nums, int k) {
//         long[] arr = new long[k];

//         for (int i = 0; i < nums.length; i++) {
//             long product = 1;

//             for (int j = i; j < nums.length; j++) {
//                 product = (product * nums[j]) % k;
//                 arr[(int) product]++;
//             }
//         }

//         return arr;
//     }
// }

class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] prev = new long[k];

        for (int num : nums) {

            long[] curr = new long[k];

            // Start a new subarray
            int rem = num % k;
            curr[rem]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (prev[r] > 0) {
                    int newRem = (int) ((long) r * num % k);
                    curr[newRem] += prev[r];
                }
            }

            // Add subarrays ending at current index
            for (int r = 0; r < k; r++) {
                ans[r] += curr[r];
            }

            prev = curr;
        }

        return ans;
    }
}