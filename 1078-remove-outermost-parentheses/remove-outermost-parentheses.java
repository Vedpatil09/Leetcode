class Solution {
    public String removeOuterParentheses(String s) {
        int stack=0;
        String ans="";
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' && flag ==false){
                flag=true;
                continue;
            }else if(ch==')' && stack==0){
                flag=false;
                continue;
            }else if(ch=='('){
                stack++;
                ans+=ch;

            }else if(ch==')'){
                stack--;
                ans+=ch;
            }
        }
        return ans;
    }
}