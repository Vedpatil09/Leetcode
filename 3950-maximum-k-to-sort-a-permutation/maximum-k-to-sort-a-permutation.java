
// class Solution {
//     public int sortPermutation(int[] nums) {
//         int n = nums.length;
//         int ans = 0;

//         for (int k = n - 1; k >= 1; k--) {
//             boolean valid = true;
//             boolean found = false;

//             for (int i = 0; i < n; i++) {
//                 if (nums[i] != i) {
//                     found = true;

//                     if ((nums[i] & k) != k) {
//                         valid = false;
//                         break;
//                     }
//                 }
//             }

//             if (valid && found) {
//                 ans = k;
//                 break;
//             }
//         }

//         return ans;
//     }
// }



class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (ans == -1) {
                    ans = nums[i];
                } else {
                    ans &= nums[i];
                }
            }
        }

        return Math.max(ans, 0);
    }
}
