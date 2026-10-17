class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }

        int low=1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(f(mid,piles,h)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean f(int mid,int [] piles,int h){
        long hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(piles[i]+mid-1)/mid;
        }
        
        return hours<=h;
    }
}