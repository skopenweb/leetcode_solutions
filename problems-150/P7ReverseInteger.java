public class P7ReverseInteger {
    public int reverse(int x) {
        long x1 = x;
        long x11;
        long x2 = 0;
        while(x1 != 0) {
            x11 = x1/10;
            x2 = x2*10 + x1 - 10*x11;
            x1 = x11;
        }
        if ((x2 > Integer.MAX_VALUE) || (x2 < Integer.MIN_VALUE)) {
            x2 = 0;
        }
        return (int)x2;
    }

    public static void main(String[] args) {
        P7ReverseInteger p = new P7ReverseInteger();
        System.out.println(p.reverse(2013));
    }
}
