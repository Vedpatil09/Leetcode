// class Solution {
//     public String maxSumOfSquares(int num, int sum) {
//         int no=num;
//         long ans1=0;
//         long ans2=0;

//         if(sum>num*9)return "";
//         while(no>0){
//             int cur=0;
//             if(sum>9){
//                 if(no>18){
//                 ans1=ans1*10+9;
//                 sum-=9;
//                 no--;
//                 }else{
//                     ans2=ans2*10+9;
//                 sum-=9;
//                 no--;
//                 }
                
//             }else{
//                 if(no>18){
// ans1=ans1*10+sum;
//                 sum=0;
//                 no--;
//                 }else{
//                     ans2=ans2*10+sum;
//                 sum=0;
//                 no--;
//                 }
                
//             }
           
            
//         }
//         String str="";
//         if(ans1==0){
//             str=String.valueOf(ans2);
//         }else{
//             str=String.valueOf(ans1)+String.valueOf(ans2);
//         }
         

//         // int index = 0;

//         // while (index < str.length()
//         //         && str.charAt(index) == '0') {
//         //     index++;
//         // }
//         // if (index == str.length()) {
//         //     return "0";
//         // }

        
//         // return str.substring(index);
//         return str;
//     }
// }


class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }
}
