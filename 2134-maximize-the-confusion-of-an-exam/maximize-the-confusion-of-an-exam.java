class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int low=1;
        int high=answerKey.length();
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean flag=Check(answerKey,mid,k);
            if(flag){
                ans=Math.max(ans,mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }return ans;
    }
    public boolean Check(String answerKey,int mid,int k){
        int val=0;
        int i=0;
        int j=0;
        while(j<answerKey.length()){
            if(answerKey.charAt(j)=='F'){
                val++;
            }
            if((j-i+1)==mid){
                if(val<=k){
                    return true;
                }
                else{
                    if(answerKey.charAt(i)=='F'){
                        val--;
                    }
                }
                i++;
            }
            j++;
        }
        val=0;
        i=0;
        j=0;
        while(j<answerKey.length()){
            if(answerKey.charAt(j)=='T'){
                val++;
            }
            if((j-i+1)==mid){
                if(val<=k){
                    return true;
                }
                else{
                    if(answerKey.charAt(i)=='T'){
                        val--;
                    }
                }
                i++;
            }
            j++;
        }
        return false;
    }
}