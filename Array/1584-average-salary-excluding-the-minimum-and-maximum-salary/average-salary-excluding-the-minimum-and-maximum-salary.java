class Solution {
    public double average(int[] salary) {
        int min=Integer.MAX_VALUE;;
        int max=0;
        double sum=0.00;
        int n=salary.length;
        for(int i=0;i<salary.length;i++){
            sum+=salary[i];
            if(salary[i]>max)max=salary[i];
            if(salary[i]<min)min=salary[i];
        }

        sum=sum-min-max;
        double average=sum/(n-2);
        return  average;
    }
}