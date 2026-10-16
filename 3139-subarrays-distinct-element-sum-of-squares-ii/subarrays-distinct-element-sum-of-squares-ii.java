class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            st.update(prev + 1, i);
            ans = (ans + st.squares[1]) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    private static class SegmentTree {
        long[] sum, squares, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squares = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void apply(int node, int l, int r, long k) {
            long len = r - l + 1L;
            long s = sum[node];

            squares[node] = (
                squares[node] + 2L * k % MOD * s % MOD
                + len % MOD * k % MOD * k % MOD
            ) % MOD;

            sum[node] = (s + len % MOD * k % MOD) % MOD;
            lazy[node] += k;
        }

        private void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) >>> 1;
            long k = lazy[node];

            apply(node << 1, l, mid, k);
            apply(node << 1 | 1, mid + 1, r, k);

            lazy[node] = 0;
        }

        void update(int ql, int qr) {
            update(1, 0, n - 1, ql, qr);
        }

        private void update(int node, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, 1);
                return;
            }

            push(node, l, r);
            int mid = (l + r) >>> 1;

            if (ql <= mid)
                update(node << 1, l, mid, ql, qr);

            if (qr > mid)
                update(node << 1 | 1, mid + 1, r, ql, qr);

            sum[node] = (sum[node << 1] + sum[node << 1 | 1]) % MOD;
            squares[node] =
                (squares[node << 1] + squares[node << 1 | 1]) % MOD;
        }
    }
}