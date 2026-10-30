class Solution {
    public String interpret(String command) {
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<command.length();i++){
            char ch=command.charAt(i);
            if(ch=='(')count=1;
            else if(ch==')'){
                count++;
                if(count==4){
                    sb.append("al");
                }else if(count==2){
                    sb.append("o");
                }
            }else if(ch=='a')count++;
            else if(ch=='l')count++;
            else if(ch=='G')sb.append("G");
        }
        return sb.toString();
    }
}