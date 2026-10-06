class Solution {
    public int secondHighest(String s) {
        int largest=Integer.MIN_VALUE;
        int sec=-1;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
           int x=s.charAt(i)-'0';
            if(x>=0 && x<=9){
                if(flag==true){
                    largest=x;
                    flag=false;
                }else{
                    if(x>largest){
                        sec=largest;
                        largest=x;
                    }else if(x<largest && x>sec){
                        sec=x;
                    }
                }
            }
        }
        return sec;
    }
}