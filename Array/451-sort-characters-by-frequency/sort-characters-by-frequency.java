class Solution {
    public String frequencySort(String s) {

        int freq[] = new int[75]; // FIXED (was 74)

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(freq[ch - 48] == 0) {
                freq[ch - 48] += 75 + ch - 48;
            } else {
                freq[ch - 48] += 75;
            }
        }

        Arrays.sort(freq);

        int i = 74; // FIXED
        StringBuilder sb = new StringBuilder();

        while(i >= 0 && freq[i] != 0) {

            int times = freq[i] / 75;
            int lett = freq[i] % 75;

            lett = lett + 48;
            char letter = (char) lett;

            while(times > 0) {
                sb.append(letter);
                times--;
            }
            i--;
        }

        return sb.toString();
    }
}