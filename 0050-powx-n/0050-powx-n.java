class Solution {
    public double myPow(double x, int n) {
        long power = n;

        // Handle negative exponent
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        return calculate(x, power);
    }

    public double calculate(double x, long n) {

        // Base case
        if (n == 0) {
            return 1;
        }

        double half = calculate(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}