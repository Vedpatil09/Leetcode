class Solution {
    public boolean canAliceWin(int n) {
        int temp=10;
        while(n>=temp){
            n-=temp;
            temp=temp-1;
        }
        if(temp%2==0)return false;
        return true;
    }
}