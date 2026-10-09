

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

                if (st.isEmpty()) {
                    count++;

                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        count++;
                    }
                } else {
                    st.pop();

                    if (!st.isEmpty() && i + 1 < s.length()
                            && s.charAt(i + 1) == ')') {
                        st.pop();
                        i++;
                    } else if (!st.isEmpty()) {
                        count++;
                        st.pop();
                    }
                }
            }
        }

        return count + st.size();
    }
}
