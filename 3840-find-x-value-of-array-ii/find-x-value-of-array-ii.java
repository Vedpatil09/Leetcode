// class Solution {
//     public int[] resultArray(int[] nums, int k, int[][] queries) {

//         int[] result = new int[queries.length];

//         for (int i = 0; i < queries.length; i++) {

//             int index = queries[i][0];
//             int value = queries[i][1];
//             int start = queries[i][2];
//             int x = queries[i][3];

//             // Update persists
//             nums[index] = value;

//             result[i] = f(nums, start, x, k);
//         }

//         return result;
//     }

//     int f(int[] nums, int start, int x, int k) {

//         int count = 0;
//         long product = 1;

//         for (int i = start; i < nums.length; i++) {

//             product = (product * (nums[i] % k)) % k;

//             if (product == x) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }
import java.util.*;

class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            prod = 1 % k;
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update is permanent
            update(1, 0, n - 1, index, value);

            // Query [start ... n-1]
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }

    // Build segment tree
    void build(int node, int l, int r, int[] nums) {

        tree[node] = new Node(k);

        if (l == r) {

            int v = nums[l] % k;

            tree[node].prod = v;
            tree[node].cnt[v] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        mergeInto(node);
    }

    // Merge children into parent
    void mergeInto(int node) {

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node parent = tree[node];

        parent.prod = (left.prod * right.prod) % k;

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            parent.cnt[r] = left.cnt[r];
        }

        // Prefixes that enter right
        for (int r = 0; r < k; r++) {

            int remainder = (left.prod * r) % k;

            parent.cnt[remainder] += right.cnt[r];
        }
    }

    // Point update
    void update(int node, int l, int r, int index, int value) {

        if (l == r) {

            value %= k;

            tree[node].prod = value;

            Arrays.fill(tree[node].cnt, 0);

            tree[node].cnt[value] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        mergeInto(node);
    }

    // Range query
    Node query(int node, int l, int r, int ql, int qr) {

        // Completely inside
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        // Completely left
        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        // Completely right
        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        // Crosses both
        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    // Merge two arbitrary nodes
    Node merge(Node left, Node right) {

        Node result = new Node(k);

        result.prod = (left.prod * right.prod) % k;

        // Prefixes from left
        for (int r = 0; r < k; r++) {
            result.cnt[r] = left.cnt[r];
        }

        // Prefixes that continue into right
        for (int r = 0; r < k; r++) {

            int remainder = (left.prod * r) % k;

            result.cnt[remainder] += right.cnt[r];
        }

        return result;
    }
}