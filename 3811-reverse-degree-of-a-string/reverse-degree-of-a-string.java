class Solution {
    public int reverseDegree(String s) {
        int count=1;
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int index=26-(c-'a');
            sum+=count*index;
            count++;
        }
        return sum;
    }
}