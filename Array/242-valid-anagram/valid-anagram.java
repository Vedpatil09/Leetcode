
class Solution {
    public boolean isAnagram(String s, String t) {
        // if length is not same, they can’t be anagrams
        if (s.length() != t.length()) return false;

        int[] count = new int[26];  // for letters a to z

        // increase count for s and decrease for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // check if all counts are zero
        for (int num : count) {
            if (num != 0) return false;
        }

        return true;  // all letters match
    }
}