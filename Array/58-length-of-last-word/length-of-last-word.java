class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        // String []str=s.trim().split("\\s+");
        // return str[str.length-1].length();
        s=s.trim();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' ')count++;
            else{
                break;
            }
        }return count;
    }
}