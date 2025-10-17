// class Solution {
//     public int[] sortJumbled(int[] mapping, int[] nums) {
//         int arr[]=new int [nums.length];
//         for(int i=0;i<nums.length;i++){
//             int copy=nums[i];
//             int ans=0;
//             int count=0;
//              if (copy == 0) {
//                 arr[i] = mapping[0];
//                 continue;
//             }int place=1;
//             while(copy>0 ){
//                 int n=copy%10;
                
                
//                 ans=ans+mapping[n] * place;
//                 place*=10;
//                 copy=copy/10;
                
//             }arr[i]=ans;
//         }
//         int n=arr.length;
//         //Sorting new array  same time change values of main array

//          for (int i = 0; i < n-1 ; i++) {
            
//             for (int j = 0; j < n - i-1 ; j++) {
//                 if (arr[j] > arr[j + 1]) {
                   
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                     temp=nums[j];
//                     nums[j]=nums[j+1];
//                     nums[j+1]=temp;
//                 }
//             }
//         }return nums;
//     }
// }
import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        // cache original -> mapped value
        Map<Integer, Integer> cache = new HashMap<>(n*2);
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // compute mapped value function with caching
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!cache.containsKey(num)) {
                if (num == 0) {
                    cache.put(num, mapping[0]);
                } else {
                    int copy = num;
                    int mapped = 0;
                    int place = 1;                // <-- place initialized OUTSIDE inner loop
                    while (copy > 0) {
                        int d = copy % 10;
                        mapped += mapping[d] * place;
                        place *= 10;
                        copy /= 10;
                    }
                    cache.put(num, mapped);
                }
            }
        }

        // sort indices by mapped value, tie-breaker by original index to preserve order
        Arrays.sort(idx, (a, b) -> {
            int ma = cache.get(nums[a]);
            int mb = cache.get(nums[b]);
            if (ma != mb) return Integer.compare(ma, mb);
            return Integer.compare(a, b); // stable tie-breaker
        });

        // build result in sorted order
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = nums[idx[i]];
        return res;
    }
}
