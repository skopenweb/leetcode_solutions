import java.util.Arrays;
import java.util.Scanner;

class P179LargestNum {
    public String largestNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        for (int a:nums) {
        System.out.print(a+"->") ;   
        }
        System.out.println(Arrays.asList(nums).toString());
        return "";
    }

    private void sort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            sort(nums, l, p-1);
            sort(nums, p+1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int lowIndex = l;
        for(int i = l+1; i < r; i++) {
            if (more(nums[i], nums[r]) > 0) {
                swap(nums, i, lowIndex++);
            }
        }
        if (more(nums[lowIndex], nums[r]) > 0) {
            swap(nums, lowIndex, r);
        }
        return lowIndex;
    }

    private void swap(int[] a, int l, int r) {
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
    }

    private int pow(int a, int b) {
        int s = 1;
        for (int i=0; i<b; i++) {
            s = a*s;
        }
        return s;
    }

    private int more(int a, int b) {
        int da = digits(a);
        int db = digits(b);

        int pa = pow(10, da);
        int pb = pow(10, db);
        int l = 0;
        int r = 0;
        while (true) {
            // 332, 345
            if (pa > 1) {
                pa /= 10;   // 100, 10, 1
                l = a / pa; // 332/100, 32/10, 2 
                a -= l*pa;  // 32, 2, 0
            }
            if (pb > 1) {
                pb /= 10;
                r = b / pb;
                b -= r*pb;
            }
            if (l != r) {
                return l - r;
            }
            if (a == 0 && b == 0) {
                return l-r;
            }
        }
    }

    private int digits(int a) {
        int n = 0;
        do {
            a /= 10;
            n++;
        } while(a > 0);
        return n;
    }

    public static void main(String[] args) {
        System.out.println("P179");

        P179LargestNum P = new P179LargestNum();
        Scanner s = new Scanner(System.in);
        System.out.println("P179 :\t" + P.more(830, 8308));

        // while(true) {
        //     int a = s.nextInt();
        //     int b = s.nextInt();
        //     System.out.println("P179 :\t" + P.largestNumber(new int[] {3,30,34,5,9}));
        // }
    }
}
