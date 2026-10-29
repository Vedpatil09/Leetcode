class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int push = 0;
        int pop = 0;

        while (push < pushed.length) {
            st.push(pushed[push]);
            push++;

            while (!st.isEmpty() && pop < popped.length
                    && st.peek() == popped[pop]) {
                st.pop();
                pop++;
            }
        }

        return st.isEmpty();
    }
}