class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int furtherInd=0;
        int currentJump=0;
        if(nums.length==1)return 0;
        for(int i=0;i<nums.length;i++){
            furtherInd=Math.max(furtherInd,nums[i]+i);
            if(i==currentJump){
                jumps++;
                currentJump=furtherInd;
            }
            if(currentJump>=nums.length-1)break;
        }
        return jumps;
    }
}