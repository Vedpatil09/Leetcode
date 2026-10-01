class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<>();
        for(int i=0;i<s.length();i++){
            char open=s.charAt(i);
            if(open=='[' ||open=='{' ||open=='('){
                st.push(open);
            }
            else{
                if(st.isEmpty()) return false;
                char close =st.pop();
                    if(open=='}' && close=='{' ||open==']' &&close=='[' ||open==')' && close=='('){
                        continue;
                    }
                    else{
                        return false;
                    }
            }
        }return st.isEmpty();
    }
    
}