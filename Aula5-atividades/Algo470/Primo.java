package Algo470;

public class Primo {
    public static int primo(int n) {
        int c = 0;
        int p = 2;
        while (c == 0 && p <= n / 2) {
            if (n % p == 0) {
                c = 1;
            }
            p++;
        }
        return c;
    }
}