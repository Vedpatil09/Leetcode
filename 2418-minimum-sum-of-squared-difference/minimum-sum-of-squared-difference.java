
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        int low = 0, high = max;

        // Find the minimum possible maximum difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long result = 0;

        for (int d : diff) {
            if (d > limit) {
                d = limit;
            }

            result += (long) d * d;
        }

        // Use any remaining operations to reduce differences
        long used = 0;
        for (int d : diff) {
            if (d > limit) used += d - limit;
        }

        long remaining = k - used;

        // Each difference equal to limit can be reduced by one.
        for (int d : diff) {
            if (remaining == 0) break;

            if (d >= limit && limit > 0) {
                result -= (long) limit * limit
                        - (long) (limit - 1) * (limit - 1);
                remaining--;
            }
        }

        return result;
    }
}
