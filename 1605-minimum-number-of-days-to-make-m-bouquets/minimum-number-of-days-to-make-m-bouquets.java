class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(mid,m,k,bloomDay)==true){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return ans;
        
    }
    boolean possible(int day,int bouques,int flowers,int [] bloomDay){
        int count=0;
        int Bouque=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
            }else{
                Bouque+=count/flowers;
                count=0;
            }
        }
        Bouque += count / flowers;
        if(Bouque>=bouques)return true;
        return false;
    }
}