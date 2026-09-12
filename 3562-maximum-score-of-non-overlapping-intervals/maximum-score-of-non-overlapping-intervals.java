class Solution {

    static class Interval {
        int start;
        int end;
        int weight;
        int index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        // Store original index
        for (int i = 0; i < n; i++) {

            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by ending time
        Arrays.sort(arr, (a, b) -> {
            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }

            return Integer.compare(a.start, b.start);
        });

        // Store ending times
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = arr[i].end;
        }

        /*
         * dp[i][k]
         *
         * First i intervals
         * Select exactly k intervals
         */
        State[][] dp = new State[n + 1][5];

        dp[0][0] = new State(0, new int[0]);

        for (int i = 1; i <= n; i++) {

            Interval curr = arr[i - 1];

            /*
             * Find first interval whose end >= curr.start.
             *
             * Everything before it has:
             *
             * end < curr.start
             */
            int p = lowerBound(ends, curr.start, i - 1);

            for (int k = 0; k <= 4; k++) {

                // Option 1: skip current interval
                State best = dp[i - 1][k];

                // Option 2: take current interval
                if (k > 0 && dp[p][k - 1] != null) {

                    State prev = dp[p][k - 1];

                    int[] indices =
                        Arrays.copyOf(prev.indices, k);

                    indices[k - 1] = curr.index;

                    // Answer requires sorted indices
                    Arrays.sort(indices);

                    State take = new State(
                        prev.score + curr.weight,
                        indices
                    );

                    if (better(take, best)) {
                        best = take;
                    }
                }

                dp[i][k] = best;
            }
        }

        // We need AT MOST 4 intervals
        State answer = null;

        for (int k = 0; k <= 4; k++) {

            if (better(dp[n][k], answer)) {
                answer = dp[n][k];
            }
        }

        return answer.indices;
    }

    /*
     * Find first position where:
     *
     * arr[pos] >= target
     *
     * Search only [0, right)
     */
    private int lowerBound(
        int[] arr,
        int target,
        int right
    ) {

        int left = 0;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /*
     * Decide which state is better.
     */
    private boolean better(State a, State b) {

        if (a == null) {
            return false;
        }

        if (b == null) {
            return true;
        }

        // First priority: maximum score
        if (a.score != b.score) {
            return a.score > b.score;
        }

        // Second priority:
        // lexicographically smaller indices
        for (int i = 0; i < a.indices.length; i++) {

            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i];
            }
        }

        return false;
    }
}