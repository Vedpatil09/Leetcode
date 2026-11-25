
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 31;
    static final long BASE2 = 37;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        // Precompute prefix hashes and powers
        for (int i = 0; i < n; i++) {

            pref1[i + 1] =
                (pref1[i] * BASE1 + nums[i]) % MOD1;

            pref2[i + 1] =
                (pref2[i] * BASE2 + nums[i]) % MOD2;

            pow1[i + 1] = (pow1[i] * BASE1) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE2) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid, pref1, pref2, pow1, pow2)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(
        int[] nums,
        int len,
        long[] pref1,
        long[] pref2,
        long[] pow1,
        long[] pow2
    ) {

        HashMap<Long, Integer> freq = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long h1 = (
                pref1[j] - pref1[i] * pow1[len] % MOD1 + MOD1
            ) % MOD1;

            long h2 = (
                pref2[j] - pref2[i] * pow2[len] % MOD2 + MOD2
            ) % MOD2;

            // Combine both hashes into one key
            long key = (h1 << 32) | h2;

            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        // Check if any subarray appears exactly once
        for (int count : freq.values()) {

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
