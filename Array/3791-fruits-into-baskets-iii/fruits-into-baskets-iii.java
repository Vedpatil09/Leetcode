class Solution {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree seg = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = seg.queryAndUse(fruit, 0, baskets.length - 1, 1);
            if (idx == -1) {
                unplaced++;
            }
        }

        return unplaced;
    }

    // \U0001f447 Nested class inside Solution
    class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] baskets) {
            n = baskets.length;
            tree = new int[n * 4];
            build(baskets, 0, n - 1, 1);
        }

        private void build(int[] baskets, int l, int r, int idx) {
            if (l == r) {
                tree[idx] = baskets[l];
                return;
            }
            int mid = (l + r) / 2;
            build(baskets, l, mid, 2 * idx);
            build(baskets, mid + 1, r, 2 * idx + 1);
            tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
        }

        public int queryAndUse(int fruitSize, int l, int r, int idx) {
            if (tree[idx] < fruitSize) return -1;

            if (l == r) {
                tree[idx] = -1; // mark as used
                return l;
            }

            int mid = (l + r) / 2;
            int res = -1;
            if (tree[2 * idx] >= fruitSize) {
                res = queryAndUse(fruitSize, l, mid, 2 * idx);
            } else {
                res = queryAndUse(fruitSize, mid + 1, r, 2 * idx + 1);
            }

            tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
            return res;
        }
    }
}
