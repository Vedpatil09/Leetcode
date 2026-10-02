class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        genrate("", ans, 0, 0, n);
        return ans;
    }

    public void genrate(String temp, List<String> ans, int left, int right, int n) {
        if (temp.length() == n * 2) {
            ans.add(temp);
            return;
        }
        if (left < n) {
            genrate(temp + '(', ans, left + 1, right, n);
        }
        if (right < left) {
            genrate(temp + ')', ans, left, right + 1, n);
        }
    }
}