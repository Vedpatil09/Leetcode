// class Solution {
//     public String largestOddNumber(String num) {
//         int i=num.length()-1;
//         boolean flag=false;
//         StringBuilder ans=new StringBuilder();
//         for(;i>=0;i--){
//             if((num.charAt(i)-'0')%2!=0){
//                 flag=true;
//                 break;
//         }
        
//     }if(flag==true){
//         for(int j=0;j<=i;j++){
//             ans.append(num.charAt(j));
//         }
//         }        return ans.toString();
//     }
// }
class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the end to find the last odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 != 0) {
                // return substring up to this point (inclusive)
                return num.substring(0, i + 1);
            }
        }
        return ""; // no odd digit found
    }
}
