// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int j = 0; j < nums.length; j++){
//             for(int i = j + 1; i <= j + k && i < nums.length; i++){
//                 if(nums[i] == nums[j]){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);

            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}