class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
 
        // This pointer tracks the next child waiting for a cookie.
        int childIndex = 0;
 
        // This pointer tracks the next unused cookie.
        int cookieIndex = 0;
 
        // This stores how many children have been satisfied so far.
        int satisfiedChildren = 0;
 
        while (childIndex < g.length && cookieIndex < s.length) {
            // If this cookie is large enough,
            // it can satisfy the current child.
            if (s[cookieIndex] >= g[childIndex]) {
                satisfiedChildren++;
                childIndex++;
                cookieIndex++;
            } else {
                // This cookie is too small for the least greedy
                // remaining child, so it cannot help anyone later.
                cookieIndex++;
            }
        }
 
        return satisfiedChildren;
    }
}