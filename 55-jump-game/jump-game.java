class Solution {
    public boolean canJump(int[] nums) {
        int range=nums[0];
        for(int i=1;i<nums.length;i++){
            if(range>=i){
                range=Math.max(range,i+nums[i]);
            }
           
        }
        if(range>=nums.length-1)return true;
        return false;
        
    }
}