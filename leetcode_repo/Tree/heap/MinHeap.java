package heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

interface IMinHeap {
    int getMin() throws IllegalAccessException;
    int removeMin() throws IllegalAccessException;
    void insert(int e);
    void heapifyDown(int index);
    void heapifyUp(int index);
}

public class MinHeap implements IMinHeap {
    private int[] arr;
    private int count = 0;
    public MinHeap(int size) {
        arr = new int[size];
    }

    @Override
    public int getMin() throws IllegalAccessException {
        if (count > 0) {
            return arr[0];
        } else {
            throw new IllegalAccessException("empty stack");
        }
    }

    @Override
    public int removeMin() throws IllegalAccessException {
        if (count < 1) {
            throw new IllegalAccessException("empty stack");
        }
        int min = arr[0];
        arr[0] = arr[--count];
        arr[count] = 0;
        heapifyDown(0);
        return min;
    }

    @Override
    public void insert(int e) {
        if (count < arr.length) {
            arr[count] = e;
            heapifyUp(count);
            count++;
        }
    }

    @Override
    public void heapifyDown(int index) {
        if (index >= count) {
            return;
        }
        int small = -1;
        boolean shouldHeapify = true;
        do {
            int l = getLeftChild(index);
            int r = getRightChild(index);

            small = index;
            if (l < count && arr[l] < arr[index]) {
                small = l;
            }
            if (r < count && arr[r] < arr[small]) {
                small = r;
            }
            shouldHeapify = small != index;
            if (shouldHeapify) {
                swap(arr, small, index);
            }
            index = small;
        } while(shouldHeapify);
    }

    int size() {
        return count;
    }

    void swap (int[] ar, int a, int b) {
        int t = ar[a];
        ar[a] = ar[b];
        ar[b] = t;
    }

    private int getLeftChild(int i) {
        return 2*i +1;
    }

    private int getRightChild(int i) {
        return 2*i + 2;
    }

    private int getParent(int i) {
        return (i-1)/2;
    }

    @Override
    public void heapifyUp(int i) {
        int p = getParent(i);
        while(i > 0 && arr[p] > arr[i]) {
            swap(arr, i, p);
            i = p;
            p = getParent(i);
        }
    }

    void print() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        System.out.print("[");
        while(!q.isEmpty()) {
            int e = q.poll();
            System.out.print(arr[e] + " ");

            if (getLeftChild(e) < count) {
                q.add(getLeftChild(e));
            }
            if (getRightChild(e) < count) {
                q.add(getRightChild(e));
            }
        }
        System.out.println("]");
    }


    static void sort(int[] a) {

        MinHeap m = new MinHeap(a.length);
        m.arr = a;
        m.count = a.length;
        m.sort(0);
    }

    void sort(int i) {
        if (i >= count) {
            return;
        }
        sort(getLeftChild(i));
        sort(getRightChild(i));

        heapifyDown(i);
        print();
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("MinHeap");
        MinHeap m = new MinHeap(11);
        for (int i=0; i<=5; i++) {
            m.insert(i*2);
        }
        for (int i=5; i>0; i-=2) {
            m.insert(i);
        }
        m.print();
        System.out.println("size = "+ m.size());

        // for (int i=0; i<9; i++) {
        //     m.removeMin();
        //     m.print();
        // }


        int[] b = {1, 4, 10, 2, 5, 9, 6};

        MinHeap.sort(b );

        System.out.println(Arrays.toString(b));

    }

}