class Solution {
    Set<String> ans = new HashSet<>();
    int minRemove = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        backtrack(s, 0, "");

        return new ArrayList<>(ans);
    }

    void backtrack(String s, int index, String current) {

        if (index == s.length()) {

            if (isValid(current)) {

                int removed = s.length() - current.length();

                if (removed < minRemove) {
                    ans.clear();
                    minRemove = removed;
                    ans.add(current);
                } 
                else if (removed == minRemove) {
                    ans.add(current);
                }
            }

            return;
        }

        char ch = s.charAt(index);


        backtrack(s, index + 1, current + ch);

        if (ch == '(' || ch == ')') {
            backtrack(s, index + 1, current);
        }
    }

    boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } 
            else if (ch == ')') {
                balance--;

                if (balance < 0)
                    return false;
            }
        }

        return balance == 0;
    }
}