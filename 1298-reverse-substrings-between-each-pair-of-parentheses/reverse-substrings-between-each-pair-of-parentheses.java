import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder temp = new StringBuilder();
                // Pop characters until matching '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                // Pop the '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // Push back the reversed characters
                for (int i = 0; i < temp.length(); i++) {
                    stack.push(temp.charAt(i));
                }
            } else {
                stack.push(c);
            }
        }

        // Build final result from stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}