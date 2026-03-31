class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            int count=0;
            int x=k;
            for( int j=i;j<n;j++){
                if(nums[j]==1){
                    count++;
                }else if(nums[j]==0 && x>0){
                    x--;
                    count++;
                }else break;
                max=Math.max(max,count);
            }
        }return max;
    }
}