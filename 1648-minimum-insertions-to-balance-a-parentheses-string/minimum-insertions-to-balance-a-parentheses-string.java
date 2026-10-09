
import java.util.Stack;

class Solution {
    public int minInsertions(String s) {
        int count = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(')');
                st.push(')');
            } else {
                // If there is no opening parenthesis needing a ')'
                if (st.isEmpty()) {
                    count++; // Insert '('

                    // Check if the next ')' forms a pair
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        count++; // Insert the missing ')'
                    }
                } else {
                    st.pop();

                    // If one ')' is still needed, check the next character
                    if (!st.isEmpty() && i + 1 < s.length()
                            && s.charAt(i + 1) == ')') {
                        st.pop();
                        i++;
                    } else if (!st.isEmpty()) {
                        count++; // Insert the missing ')'
                        st.pop();
                    }
                }
            }
        }

        return count + st.size();
    }
}
