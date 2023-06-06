import java.util.Arrays;

public class Partition {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, -3, 4, 10, 5, 0, 0, 1, 2, -10, -11};
        doPartition(a);
        System.out.println("Partition:\t");
        System.out.println(Arrays.toString(a));
    }    

    private static void doPartition (int[] a) {
        int l = 0;
        int r = a.length - 1;

        while(l < r) {
            while( l < r && a[l] > 0) {
                l++;
            }
            while (r > l && a[r] <= 0) {
                r--;
            }
            if (a[l] <= 0 && a[r] > 0) {
                int t = a[l];
                a[l] = a[r];
                a[r] = t;
                l++;
                r--;
            }
        }
    }
}
