import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NearestStar {

    public static void main(String[] args) throws IOException {
        System.out.println("\nNearest Star");
        // Input star
        // Populate star-index into array
        // test for all the row index
        //

        // System.out.println("Nearest Star:\t" + (14%12));

        InputStream inputStream = new FileInputStream("test_cases.txt");
        Scanner s = new Scanner(inputStream);

        int testCases = s.nextInt();
        for (int i = 0; i < testCases; i++) {
            int N = s.nextInt();
            int M = s.nextInt();
            int[][] arr = new int[N][M];
            s.nextLine();
            for (int i1=0; i1<N; i1++) {
                String line = s.nextLine();
                for (int j=0; j<M; j++) {
                    arr[i1][j] = line.charAt(j) == 'S' ? 0: 1;
                }
            }
            // for (int[] ar: arr) {
            //     int[] testArr = ar;
            //     System.out.print("\n\nInput:\t"+ Arrays.toString(testArr));
            //     fill(testArr);
            //     System.out.print("\nOutput:\t"+ Arrays.toString(testArr));    
            // }
            // int[] testArr = arr[3];
            // System.out.print("Input:\t"+ Arrays.toString(testArr));
            // fill(testArr);
            // System.out.print("\nOutput:\t"+ Arrays.toString(testArr));

            // System.out.print("[");
            // for (int e: arr[0]) {
            //     System.out.print(" "+e);
            // }
            // System.out.println("]");

            print(arr);
            long time = System.currentTimeMillis();
            int result = solve(arr);
            long time2 = System.currentTimeMillis();

            System.out.println("time:\t"+ (time2-time));
            System.out.println("dist:\t" + result);            
        }
        inputStream.close();
        s.close();
    }

    private static int solve(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;

        for (int i=0; i<N; i++) {
            fill(arr[i]);
        }
        print(arr);
        int m = Integer.MAX_VALUE;
        for (int i1=0; i1<M; i1++) {
            int sum = 0;
            for (int i=0; i<N; i++) {
                sum += arr[i][i1];        
            }
            if (sum < m) {
                m = sum;
            }
        }
        return m;
    }

    static void print(int[][] a) {
        int N = a.length;
        int M = a[0].length;
        System.out.println("[");
        for (int i=0 ; i<N; i++) {
            System.out.print(" [");
            for (int j=0 ; j<M; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    static int distToZero(int[] a, int j, int[][] cache) {
        int l = j;
        int r = j;
        int last = 0;
        boolean found = false;

        while (!found) {
            int l1 = norm(l, a.length);
            int r1 = norm(r, a.length);
            if (a[l1] == 0) {
                last = l;
                found = true;
            } else if (a[r1] == 0) {
                last = r;
                found = true;
            } else {
                l--;
                r++;
            }
        }
        return last > j ? last-j : j-last;
    }

    static void fillBfs(int[] a) {
        List<Integer> elems = new LinkedList<>();
        for (int i=0; i<a.length; i++) {
            if (a[i] != 0) {
                a[i] = -1;
            } else {
                elems.add(i);
            }
        }
        fillBfs(a, elems);
    }

    static void fillBfs(int[] a, List<Integer> l) {
        if (l.isEmpty()) {
            return;
        }
        List<Integer> l1= new LinkedList<>();
        for (int e: l) {
            int c1 = norm(e+1, a.length);
            int c2 = norm(e-1, a.length);
            if (a[c1] == -1) {
                a[c1] = a[e] + 1;
                l1.add(c1);
            }
            if (a[c2] == -1) {
                a[c2] = a[e] + 1;
                l1.add(c2);
            }
        }
        fillBfs(a, l1);
    }

    static void fillBfs2(int[] a) {
        Queue<Integer> q = new LinkedList<>();
        int M = a.length;
        for (int i=0; i<a.length; i++) {
            if (a[i] == 0) {
                q.add(i);
            } else {
                a[i] = -1;
            }
        }
        while(!q.isEmpty()) {
            int e = q.poll();

            int c1 = norm(e+1, M);
            if (a[c1] == -1) {
                a[c1] = a[e] + 1;
                q.add(c1);
            }
            int c2 = norm(e-1, M);
            if (a[c2] == -1) {
                a[c2] = a[e] + 1;
                q.add(c2);
            }
        }

    }

    static void fill(int[] a) {
        int visited = 0;
        int l = 0;
        int r = 0;
        int N = a.length;
        while (visited < N) {
            if (a[norm(l, N)] != 0) {
                l--;
            } else if(a[norm(r, N)] != 0) {
                r++;
            } else {
                for (int i=l+1; i<r; i++) {
                    a[norm(i, N)] = Math.min(i-l, r-i);
                }
                visited += r-l;
                l = r;
                r++;
            }
        }
    }

    static int fill (int[] a, int i) {
        // this functions go into infinite loop
        System.out.println("a = "+Arrays.toString(a)+ "i = "+i);
        int i1 = i%a.length;
        if (i1 < 0) {
            i1 = i1 + a.length;
        }
        if (a[i1] == 0) {
            return 0;
        }

        int l = fill(a, i-1);
        int r = fill(a, i+1);

        a[i1] = Math.min(l, r) + 1;
        return a[i1];
    }

    static int norm(int a, int N) {
        a = a % N;
        if (a < 0) {
            a += N;
        }
        return a;
    }
}
