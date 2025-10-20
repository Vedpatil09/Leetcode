class Solution {
    public int lengthOfLastWord(String s) {
        
        String []str=s.trim().split("\\s+");
        return str[str.length-1].length();
    }
}