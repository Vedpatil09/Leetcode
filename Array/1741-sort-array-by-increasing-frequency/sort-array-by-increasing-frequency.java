class Solution {
    public int[] frequencySort(int[] nums) {
        int n=nums.length;
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(a) - map.get(b); // freq ascending
            }
            return b - a; // value descending
        });
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    return nums;
    }
}