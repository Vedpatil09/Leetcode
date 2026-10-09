class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int st = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st+=2;
                
            } else {

                if (st==0) {
                    count++;

                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        count++;
                    }
                } else {
                    st--;

                    if (st!=0 && i + 1 < s.length()
                            && s.charAt(i + 1) == ')') {
                        st--;
                        i++;
                    } else if (st!=0) {
                        count++;
                        st--;
                    }
                }
            }
        }

        return count + st;
    }
}
