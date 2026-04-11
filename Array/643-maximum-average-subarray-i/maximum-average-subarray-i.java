// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         double sum = 0;
//         double avg = Integer.MIN_VALUE;
//         double maxAvg = Integer.MIN_VALUE;
//         int j = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (i <= k - 2) {
//                 sum += (double) nums[i];
//             } else {
//                 sum += (double) nums[i];
//                 avg = sum / k;
//                 maxAvg = Math.max(maxAvg, avg);
//                 sum -= (double) nums[j];
//                 j++;
//             }

//         }

//         return maxAvg;
//     }
// }
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // Step 1: First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Step 2: Sliding window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];      // add next element
            sum -= nums[i - k];  // remove previous element
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }
}