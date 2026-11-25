
class Solution {

    public int maxLength(int[] nums) {

        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < n; j++) {

                int num = nums[j];

                product *= num;
                gcd = findGCD(gcd, num);
                lcm = findLCM(lcm, num);

                if (product == gcd * lcm) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    private int findGCD(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private int findLCM(int a, int b) {
        return (a / findGCD(a, b)) * b;
    }
}
