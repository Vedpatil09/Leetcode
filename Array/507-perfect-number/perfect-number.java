class Solution {
    public boolean checkPerfectNumber(int num) {
       int sum = 0;
       int n=num;
       if(n==1)return false;
         for (int i = 1; i * i <= n; i++) {
            // If i is a divisor of n
            if (n % i == 0) {
                // If i is the square root of n or i is 1, add i to the sum
                if (i * i == n || i == 1)
                    sum += i;
                else {
                    // Otherwise, add both i and n / i to the sum
                    sum += i + n / i;
                }
            }
         }
        return sum == n;
    }
}