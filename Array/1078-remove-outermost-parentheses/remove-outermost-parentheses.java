// class Solution {
//     public String removeOuterParentheses(String s) {
//         int depth=0;
//         StringBuilder sb = new StringBuilder();
//          for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c == '(') {
//                 if (depth > 0) sb.append(c); 
//                 depth++;
//             } else {
//                 depth--; 
//                 if (depth > 0) sb.append(c); 
//             }
//         }return sb.toString();
        
//     }
// }
import java.util.Scanner;
class Solution {
    static {
        for(int i = 0; i < 500; i++) removeOuterParentheses("()");
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(cnt>0) sb.append(ch); 
                cnt++;
            }
            else{
                cnt--;
                if(cnt>0) sb.append(ch);
            }
        }        
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(removeOuterParentheses(s));
    }
}