class Solution {
    public int fib(int n) {

        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev1 = 0; // F(0)
        int prev2 = 1; // F(1)

        // Loop from 2 to n
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2; // F(i) = F(i-1) + F(i-2)

            // Move forward
            prev1 = prev2;
            prev2 = current;
        }

        return prev2; // Final Fibonacci number
    }
}
