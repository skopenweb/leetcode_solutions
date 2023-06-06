public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("New Binary Search: \t");
        int[] arr = {1, 4, 5, 5, 7, 8, 8, 8, 9, 10, 11, 21, 33};

        for (int i=0; i<arr.length; i++) {
            int p = findFirstBinaryIterative(arr, arr[i]);
            if (p == i) {
                System.out.println("OK");
            } else {
                System.out.println("\tNOT OKAY");
            }
        }
    }

    static int findRotated(int[] a, int start, int end, int target) {
        int mid = (start + end)/2;

        int p = a[mid];

        // find which partition answer belongs to
        if (a[mid] == target) {
            return mid;
        }
        if (target < p) {
            if (a[start] < p) {
                if (target <= a[start])
                    return findRotated(a, mid + 1, end, target);
                else {
                    return findRotated(a, start, mid - 1, target);
                }
            } else {
                if (target < a[start]) {
                    // not found
                    return -1;
                } else {
                    return findRotated(a, start, mid - 1, target);
                }
            }
        } else { // target > a[mid]

            if (a[start] < a[mid]) {
                return findRotated(a, mid + 1, end, target);
            } else {
                if (target < a[start])
                    return findRotated(a, mid + 1, end, target);
                else {
                    return findRotated(a, start, mid - 1, target);
                }
            }
        }
    }

    static void test() {
        int[] a = {1,4,5,5,5,5,6,6,6, 8,9, 9, 10, 12, 17, 17, 17};

        for(int e: a) {
            System.out.print(" "+e);
        }
        System.out.println("");
        for (int i=0; i<5; i++) {
            int n = new java.util.Random().nextInt(100);
            int index = findLast(a, n);
            int index2 = findLastBinary(a, 0, a.length - 1, n);

            if (index != index2) {
                System.out.println("index = "+index);
                System.out.println("index2 = "+index2);
                System.out.printf("WRONG, mismatch for element  %d", n);
            }
        }
    }

    static int findFirst(int[] a, int e) {
        if (a.length == 0) {
            return -1;
        }
        int index = -1;

        while(++index < a.length && a[index] < e);
        if (index == a.length) {
            return -1;
        }
        return index;
    }

    static int findLast(int[] a, int e) {
        if (a.length == 0) {
            return -1;
        }

        int index = -1;
        while(++index < a.length && a[index] <= e);
        if (index == a.length && a[index - 1] != e) {
            return -1;
        }
        return a[--index] == e ? index: -1;
    }

    static int findFirstBinary(int[] a, int s, int e, int target) {
        if (e == s) {
            return a[s] == target ? s: -1;
        }
        int mid = (s + e)/2;
        int index;
        if (target <= a[mid]) {
            index = findFirstBinary(a, s, mid, target);
        } else {
            index = findFirstBinary(a, mid+1, e, target);
        }
        return index;
    }

    static int findLastBinary(int[] a, int s, int e, int target) {
        if (e == s) {
            return a[s] == target ? s: -1;
        }
        int mid = (s + e + 1)/2;
        int index;
        if (target < a[mid]) {
            index = findLastBinary(a, s, mid-1, target);
        } else {
            index = findLastBinary(a, mid, e, target);
        }
        return index;
    }

    // new
    static int findFirstBinaryIterative(int [] a, int target) {
        int l = 0;
        int r = a.length - 1;
        int mid = (l+r)/2;
        while (l < r) {
            if (target <= a[mid]){
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = l + (r-l)/2;
        }
        return mid;
    }

    static void search(int e, int[] a, int start, int end) {
        int mid = start + (end - start)/2;
        if (start > end) {
            System.out.println("not found element searching");
            return;
        }
        if (a[mid]  == e) {
            System.out.println("\telement found :\t"+ e);
            return;
        } else if (e > a[mid]) {
            search(e, a, mid + 1, end);
        } else {
            search(e, a, start, mid -1);
        }

    }
}
