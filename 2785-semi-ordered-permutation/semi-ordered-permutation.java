
class Solution {
    public int semiOrderedPermutation(int[] nums) {
        if (nums[0] == 1 && nums[nums.length - 1] == nums.length)
            return 0;

        int first = 0;
        int last = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) first = i;
            if (nums[i] == nums.length) last = i;
        }

        int diff = first - last;
        int start_diff = first;
        int last_diff = nums.length - 1 - last;

        int ans = start_diff + last_diff;

        if (diff > 0) {
            ans--;
        }

        return ans;
    }
}
