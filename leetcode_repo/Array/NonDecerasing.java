import java.util.Arrays;
import java.util.Stack;

public class NonDecerasing {

    public static void main(String[] args) {
        NonDecerasing n = new NonDecerasing();
        int[] a = {11,7,7,9};
        int[] b = {19,19,1,7};
        System.out.println(n.maxNonDecreasingLength(a, b));
    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int N = nums1.length;
        
        // recursion:
        // dp1[i] = cond(dp1[i-1] + 1)
        // dp2[i] = cond(dp2[i-1])
        
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        
        dp1[0] = dp2[0] = 1;
        
        for (int i=1; i<N; i++) {
            int curr1, curr2;
            curr1 = curr2 = 1;

            if (nums1[i] >= nums1[i-1]) curr1 = 1 + dp1[i-1];
            if (nums1[i] >= nums2[i-1]) curr2 = 1 + dp2[i-1];

            dp1[i] = max(curr1, curr2);

            curr1 = curr2 = 1;

            if (nums2[i] >= nums1[i-1]) curr1 = 1 + dp1[i-1];
            if (nums2[i] >= nums2[i-1]) curr2 = 1 + dp2[i-1];
            
            dp2[i] = max(curr1, curr2);
        }

        System.out.println("dp1 = " + Arrays.toString(dp1)+"max1 = "+ max(dp1));
        System.out.println("dp1 = " + Arrays.toString(dp1)+"max2 = "+ max(dp2));

        return max(max(dp1), max(dp2));
    }

    int max(int[] a) {
        int max = a[0];
        for (int i=1; i<a.length; i++) {
            if (max < a[i]) max = a[i];
        }
        return max;
    }
    
    int max(int a, int b) {
        return a > b ? a: b;
    }
}