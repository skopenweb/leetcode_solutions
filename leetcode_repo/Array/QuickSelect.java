public class QuickSelect {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        return quickSelect(A, 0, A.length -1, B);    
    }

    int quickSelect(int[] a, int start, int end, int k) {

        //print(a, start, end);
        if (start == end && start == k) {
            return a[k];
        }
        int pivot = a[end];
        int firstHigh = start;
        while (firstHigh < end && a[firstHigh] < pivot) {
            firstHigh ++;
        }

        for (int i=firstHigh; i<end; i++) {
            if (a[i] < pivot) {
                swap(a, i, firstHigh++);
            } else if (a[i] == pivot) {
                firstHigh++;
            }
        }
        swap(a, end, firstHigh);
        
        int p = firstHigh;
        if (p <= k) {
            return quickSelect(a, p, end, k);
        } else {
            return quickSelect(a, start, p-1, k);
        }
    }
    
    private void print(int[] a, int start, int end) {
        System.out.print("[");
        for (int i=start; i<=end; i++) {
            System.out.print(" "+ a[i]);
        }
        System.out.println("]");
    }

    void swap(int[] ar, int a, int b) {
        int t = ar[a];
        ar[a] = ar[b];
        ar[b] = t;
    }

    public static void main(String[] args) {
        int[] arr =  {10, 11, 12, 0, 1,2,3,4,5,6,7,8,9};
        int[] a1 = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        int k = 5;

        // for (int i=0; i<arr.length; i++) {
        //     System.out.print (" "+ new QuickSelect().kthsmallest(arr, i));
        // }
       System.out.println(k+"th "+"smallest=\t"+new QuickSelect().kthsmallest(a1, k));
    }
}

// Om prakash 
// Bairiya Waterpark road
// 9334513825