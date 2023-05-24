public class P4Median {

    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int m = a1.length;
        int n = a2.length;

        int i1 = 0;
        int i2 = 0;

        int prev = 0;
        int curr = 0;

        while (i1+i2 <= (m+n)/2) {
            if (i1 == m) {
                prev = curr;
                curr = a2[i2++];
             } else if (i2 == n) {
                 prev = curr;
                 curr = a1[i1++];
             } else {
                 if (a1[i1] < a2[i2]) {
                     prev = curr;
                     curr = a1[i1++];
                 } else {
                     prev = curr;
                     curr = a2[i2++];
                 }
             }
        }
        if (((m+n)&1) == 0) {
            return (curr + prev)/2.0;
        } else {
            return curr;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println("P4Median\t "+ new P4Median().findMedianSortedArrays(a, b));

    }    
}
