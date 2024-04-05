/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class Shame {

    public static void main(String args[] ) throws Exception {
      Scanner s = new Scanner(System.in);

      int N = s.nextInt();
      int P = s.nextInt();

      int[] n = new int[N];
      int[] p = new int[P];
      
      for (int i=0; i<N; i++) {
         n[i] = s.nextInt();
      }
      for (int i=0; i<P; i++) {
         p[i] = s.nextInt();
      }

      int L = removeDups(n);
      int ans = findMax(n, L, p[0]);
      System.out.println(ans);
      for (int i=1; i<P; i++) {
         if (p[i] == p[i-1]) {
            System.out.println(ans);
         } else {
            ans = findMax(n, L, p[i]);
            System.out.println(ans);
         }
      }
   }

   static int removeDups(int[] a) {
      int i = 0;
      int j = 1;
      while (j < a.length) {
         if (a[j] != a[i]) {
            a[++i] = a[j];
         }
         j++;
      }
      return (i+1);
   }

   static int findMax(int[] a, int L, int e) {
      int l = 0;
      int r = L - 1;

      if (e > a[l]) {
        return 1;
      }

      while (l < r) {
         int mid = (l+r+1)/2;
         if (a[mid] == e) {
            l = mid;
            break;
         } else if(a[mid] > e) {
            l = mid;
         } else {
            r = mid - 1;
         }
      }
      if (a[l] == e) return l+1;
      else return l+2;
   }

}
