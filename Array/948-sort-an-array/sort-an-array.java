class Solution {
    public int[] sortArray(int[] nums) {
        // if(nums.length==1)return nums;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=1;j<nums.length;j++){
        //         if(nums[j]<nums[j-1]){
        //             int temp=nums[j-1];
        //             nums[j-1]=nums[j];
        //             nums[j]=temp;
        //         }
        //     }
        // }  
        Arrays.sort(nums);
         return nums; }
}