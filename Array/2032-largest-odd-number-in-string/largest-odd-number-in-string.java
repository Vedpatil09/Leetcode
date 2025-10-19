class Solution {
    public String largestOddNumber(String num) {
        int i=num.length()-1;
        boolean flag=false;
        StringBuilder ans=new StringBuilder();
        for(;i>=0;i--){
            if((num.charAt(i)-'0')%2!=0){
                flag=true;
                break;
        }
        
    }if(flag==true){
        for(int j=0;j<=i;j++){
            ans.append(num.charAt(j));
        }
        }        return ans.toString();
    }
}