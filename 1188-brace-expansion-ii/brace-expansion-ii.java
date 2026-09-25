import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Deque<Set<String>> stackRes = new ArrayDeque<>();
        Deque<Set<String>> stackCur = new ArrayDeque<>();

        Set<String> res = new HashSet<>();
        Set<String> cur = new HashSet<>();
        cur.add(""); // Base element for Cartesian product multiplication

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetter(c)) {
                // Multiply every string in 'cur' with character 'c'
                Set<String> nextCur = new HashSet<>();
                for (String str : cur) {
                    nextCur.add(str + c);
                }
                cur = nextCur;

            } else if (c == '{') {
                // Save state to stack and enter inner block
                stackRes.push(res);
                stackCur.push(cur);

                res = new HashSet<>();
                cur = new HashSet<>();
                cur.add("");

            } else if (c == '}') {
                // Complete union for the current block
                res.addAll(cur);
                Set<String> blockResult = res;

                // Pop outer context
                Set<String> prevRes = stackRes.pop();
                Set<String> prevCur = stackCur.pop();

                // Multiply outer 'cur' with current block result
                cur = new HashSet<>();
                for (String prefix : prevCur) {
                    for (String str : blockResult) {
                        cur.add(prefix + str);
                    }
                }
                res = prevRes;

            } else if (c == ',') {
                // Add completed product group 'cur' into 'res', reset 'cur'
                res.addAll(cur);
                cur = new HashSet<>();
                cur.add("");
            }
        }

        // Final union and sort
        res.addAll(cur);
        List<String> sortedList = new ArrayList<>(res);
        Collections.sort(sortedList);
        
        return sortedList;
    }
}