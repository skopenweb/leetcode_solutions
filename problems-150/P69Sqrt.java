public class P69Sqrt {

    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long mid = 0;
        while (start < end) {
            mid = (start + end + 1) / 2;
            long m2 = mid * mid;
            if (m2 <= x) {
                start = mid;
            } else {
                // m2 > x
                end = mid -1;
            }
        }
        return (int)start;
    }

    public static void main(String[] args) {
        System.out.println(new P69Sqrt().mySqrt(8));
    }
    
}
