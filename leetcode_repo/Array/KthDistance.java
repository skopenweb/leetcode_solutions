import java.util.*;

class KthDistance {
    public int smallestDistancePair(int[] a, int k) {
        Arrays.sort(a);
        int N = a.length;
        System.out.println("array: \t"+ Arrays.toString(a));

        List<Integer> listNum = new ArrayList<>();
        List<Integer> listCount = new ArrayList<>();
        
        int prev = a[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (a[i] == prev) {
                count++;
            } else {
                listNum.add(prev);
                listCount.add(count);
                count = 1;
                prev = a[i];
            }
        }
        listNum.add(prev);
        listCount.add(count);
        int M = listCount.size();

        // numbers are converted {num -> freq}
        for (int i = 0; i < M; i++) {
            System.out.printf("{%d -> %d}, ", listNum.get(i), listCount.get(i));
        }

        int[] ar = new int[M];
        for (int i = 0; i < M; i++) {
            ar[i] = i + 1;            //index of nearest number
        }

        // loop till count is 'k'
        count = 0;
        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < M && count < k; i++) {
            count += nc2(listCount.get(i));
        }
        if (count >= k) {
            return 0;
        }

        while (count < k) {
            int minIndex = 0;
            dist = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {
                if (ar[i] < M) {
                    int d = listNum.get(ar[i]) - listNum.get(i);
                    if (d < dist) {
                        dist = d;
                        minIndex = i;
                    }
                }
            }
            count += (listCount.get(minIndex) * listCount.get(ar[minIndex]));
            ar[minIndex]++;
        }
        return dist;
    }

    int nc2(int i) { return (i*(i-1))/2; }

    public static void main(String[] args) {
        int[] a = {100, 62, 4};
        int k = 2;
        System.out.println("Kth minimum distance:\t"+ new KthDistance().smallestDistancePair(a, k));
    }
}