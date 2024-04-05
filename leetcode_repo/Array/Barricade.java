/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class Barricade {
   public static void main(String args[] ) throws Exception {
      Scanner s = new Scanner(System.in);
      int N = s.nextInt();
      int K = s.nextInt();
      char[] inp = s.next().toCharArray();

      long ans = count(inp, 0, 1, K);
      System.out.println(ans%(1000000007));
   }

   private static long count(char[] arr, int last, int curr, int K) {
      long ct = 0;
      if (curr == arr.length) {
        int num = extract(arr, last, curr);
        if (num <= K) return 1;
        else return 0;
      }
      if ((curr == last + 1 && arr[curr] == '0')) {
         return 0;
      }
      int num = extract(arr, last, curr);
      if (num > K) {
         return 0;
      }
      ct += count(arr, last, curr + 1, K);
      ct += count(arr, curr, curr + 1, K);
      return ct;
   }

   private static int extract(char[] ar, int from, int till) {
      int num = 0;
      for (int i=from; i<till; i++) {
         num = num * 10 + (ar[i] - '0');
      }
      return num;

   }
}













