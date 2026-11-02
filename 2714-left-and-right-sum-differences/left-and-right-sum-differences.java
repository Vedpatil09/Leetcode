class Solution {
    public int[] leftRightDifference(int[] nums) {
        int []left=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int sum1=sum;
        for(int i=nums.length-1;i>=0;i--){
            left[i]=sum-nums[i];
            sum=left[i];
        }
        sum=sum1;
        for(int i=0;i<nums.length;i++){
            nums[i]=sum-nums[i];
            sum=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]-left[i]);
        }
        return nums;
    }
}