class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double avg=Integer.MIN_VALUE;
        double maxAvg=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(i<=k-2){
                sum+=(double)nums[i];
            }
            else{
                sum+=(double)nums[i];
                avg=sum/k;
                maxAvg=Math.max(maxAvg,avg);
                sum-=(double)nums[j];
                j++;
            }
           
        }
        // sum+=(double)nums[k-1];
        //         avg=sum/k;
        //         maxAvg=Math.max(maxAvg,avg);
            return maxAvg;
    }
}