import java.util.Random;

public class Sorter {

    static void sort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    static void print(int[] a) {
        System.out.print("[ ");
        for (int e:a) {
            System.out.print(e+" ");
        }
        System.out.print("]");
    }

    private static void quicksort(int[] a, int start, int end) {
        if (start < end) {
            int p = partition2(a, start, end);
            quicksort(a, start, p - 1);
            quicksort(a, p + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];

        int firstHigh = start;
        int i = start;
        while (i < end) {
            if (a[i] < pivot) {
                swap(a, i, firstHigh);
                firstHigh++;
            }
            i++;
        }
        swap(a, firstHigh, end);
        return firstHigh;
    }

    private static int partition2(int[] a, int s, int e) {
        int pivot = a[e];
        int l = s;
        int r = e - 1;

        while(l < r) {
            while(l < r && a[l] < pivot) {
                l++;
            }
            while(l < r && a[r] >= pivot) {
                r--;
            }
            if (l < r) {
                swap(a, l, r);
            }
        }

        if (a[l] > pivot) {
            swap(a, pivot, l);
        }
        return l;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int[] rndArr() {
        Random r = new Random(System.currentTimeMillis());
        int l = 10 + r.nextInt(40);
        int[] a = new int[l];
        for (int i=0; i < l; i++) {
            a[i] = r.nextInt(l);
        }
        return a;
    }

    private static boolean testSort(int[] a) {
        boolean sorted = true;
        for (int i=1; i<a.length && sorted; i++) {
            sorted = a[i] >= a[i-1];
        }
        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("ThreeSum Solution");

        int[] ar = {4, 1, 5, 7, 8};
        quicksort(ar, 0, ar.length - 1);
        print(ar);

        for (int i=0; i<50; i++) {
            int[] arr = rndArr();
            sort(arr);
            System.out.println(testSort(arr));
        }

        int[] a = {4,1, 5, 7, 8};
        quicksort(a, 0, a.length - 1);
        print(a);

        for (int i=0; i<50; i++) {
            int[] a1 = rndArr();
            sort(a1);
            System.out.println(testSort(a1));
        }
    }
}
