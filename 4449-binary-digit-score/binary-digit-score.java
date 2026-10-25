
class Solution {
    public int calculateScore(int a, int b) {
        int acount=0;
        int bcount=0;
        while(a!=0){
            if(a%2==1){
                acount++;
            }
             a=a/2;
        }
         while(b!=0){
            if(b%2==1){
                bcount++;
            }
             b=b/2;
        }
        if(acount>=bcount)return acount*bcount;
        return bcount/acount;
    }
}
