public class NearestNum {
    public static void main(String[] args) {
        int[] a = {0, 2, 2, 4, 4, 6, 6, 7, 8, 12, 19, 20, 18};
        System.out.println("Nearest Number "+ near(a, 9));

    
    }

    static int near(int[] a, int e) {
        int l = 0;
        int r = a.length - 1;
        if (e <= a[l]) {
            return l;
        } else if (e >= a[r]) {
            return r;
        }
        int mid = 0;
        while(l <= r) {
            mid = l + (r-l)/2;
            if (a[mid] == e) {
                return e;
            } else if (e > a[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int ans = a[mid];
        if (a[mid] > e && mid > 0) {
            if (a[mid] - e > e - a[mid -1]) {
                ans = a[mid - 1];
            }
        } else if (a[mid] < e && mid < a.length - 1) {
            if (e - a[mid] > a[mid + 1] - e) {
                ans = a[mid + 1];
            }
        }
        return ans;
    }
    
}
