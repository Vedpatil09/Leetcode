class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')count++;
            else if(s.charAt(i)==')')count--;
            if(count==1 && s.charAt(i)=='(')continue;
            else if(count==0 && s.charAt(i)==')')continue;
            else {
                ans=ans+s.charAt(i);
            }
        }return ans;
        
    }
}