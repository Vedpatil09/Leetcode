class Solution {
    public String reverseWords(String s) {
        String []str=s.split(" ");
        for(int i=0;i<str.length;i++){
        str[i]  = new StringBuilder(str[i]).reverse().toString();
        }
        StringBuilder string=new StringBuilder();
        for(int i=0;i<str.length;i++){
        string.append(str[i]+" ");
        }
        return string.toString().trim();
        
    }
}