
public class Main {
    public static void main(String[] args) {
        int n = 6;
        boolean result = isUgly(n);
        System.out.println(result);
    }

    public static boolean isUgly(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;

        for (int factor : new int[] {2, 3 ,5})
            n = keepDividingWhenDivisible(n, factor);

        return n == 1;
    }

    private static int keepDividingWhenDivisible(int dividend, int divisor) {
        while (dividend % divisor == 0)
            dividend /= divisor;
        return dividend;
    }
}