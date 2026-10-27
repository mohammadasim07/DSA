
class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long before taking absolute value
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        // Determine the sign
        boolean negative = (dividend < 0) != (divisor < 0);

        long quotient = 0;

        while (a >= b) {
            long temp = b;
            long multiple = 1;

            // Find the largest doubled divisor that fits
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            quotient += multiple;
        }

        return negative ? (int) -quotient : (int) quotient;
    }
}
