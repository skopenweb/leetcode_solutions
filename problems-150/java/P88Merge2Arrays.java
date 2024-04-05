import java.util.Arrays;

class P88 {
     public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0;
        int r = 0;
        while (r < n) {
            while(l < m + r && nums1[l] < nums2[r]) l++;
            for (int i = n+r; i > l; i--) {
                nums1[i] = nums1[i-1];
            }
            nums1[l++] = nums2[r++];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {4, 5, 6};
        merge(a, a.length - b.length, b, b.length);
        System.out.println(Arrays.toString(a));
        System.out.println("P88: Merge 2 arrays");
    }
}