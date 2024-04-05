import java.util.Comparator;
import java.util.PriorityQueue;

public class KthDistanceViaHeap {

    private Comparator reverse = new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };
        
    int findKthDistance(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(reverse);

        for (int i=0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                pq.add(Math.abs(a[i] - a[j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        // int[] a = {1, 6, 1};
        // int k = 3;

        int[] a = {100, 62, 4};
        int k = 2;
        System.out.println("Kth Dist\t"+ new KthDistanceViaHeap().findKthDistance(a, k));
    }
}
