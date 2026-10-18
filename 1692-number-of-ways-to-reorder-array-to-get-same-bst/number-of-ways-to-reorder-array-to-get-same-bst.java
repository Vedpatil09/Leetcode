
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;
    long[] fact, invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }

        return (int) ((solve(arr) - 1 + MOD) % MOD);
    }

    private long solve(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int value = nums.get(i);

            if (value < root) {
                left.add(value);
            } else {
                right.add(value);
            }
        }

        int l = left.size();
        int r = right.size();

        long combinations = fact[l + r]
                * invFact[l] % MOD
                * invFact[r] % MOD;

        long leftWays = solve(left);
        long rightWays = solve(right);

        return combinations * leftWays % MOD
                * rightWays % MOD;
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}
