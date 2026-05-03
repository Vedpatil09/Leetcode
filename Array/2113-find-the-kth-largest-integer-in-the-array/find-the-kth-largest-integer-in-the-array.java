// class Solution {
//     public String kthLargestNumber(String[] nums, int k) {
//         long arr[]=new long [nums.length];
//         for(int i=0;i<nums.length;i++){
//             arr[i]=Long.parseUnsignedLong(nums[i]);
//         }
//         Arrays.sort(arr);
//         int count=1;
        
//         String s="";
//         for(int i=nums.length-1;i>=0;i--){
//             if(count==k){
//                 return Long.toString(arr[i]);
//             }
//             count++;

//         }return s;
//     }
// }
import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        Arrays.sort(nums, (a, b) -> {
            // Compare by length
            if (a.length() != b.length()) {
                return b.length() - a.length(); // descending
            }
            // If same length, compare lexicographically
            return b.compareTo(a);
        });

        return nums[k - 1];
    }
}