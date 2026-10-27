class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //g==children
        //s==cookies
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int std = 0;
        int ans = 0;
        while (g.length > i && s.length > std) {
            if (s[std] >= g[i]) {

                i++;
                ans++;

            }
            std++;
        }
        return i;

    }
}