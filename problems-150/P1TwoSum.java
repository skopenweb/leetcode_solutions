import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {

    /**
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] c = new int[2];
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    c[0] = i;
                    c[1] = j;
                    return c;
                }
            }
        }
        return c;
    }

    /**
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] r = new int[2];;

        for (int i=0; i<nums.length; i++) {
            m.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            int index = m.getOrDefault(key, -1);
            if (index != -1 && index != i) {
                r[0] = i; r[1] = index;
                break;
            }
        }
        return r;
    }

    /**
     * Average case: O(nlog(n))
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] a, int target) {
        int[] c = new int[2];
        int l = 0;
        int r = a.length - 1;

        int[] s = new int[a.length];
        for (int i=0; i<s.length; i++) {
            s[i] = i;
        }
        quicksort(a, l, r, s);
        while (l < r) {
            int sum = a[l] + a[r];
            if (sum == target) {
                c[0] = s[l]; c[1] = s[r];
                l = r;
            }
            else if (sum > target) {
                l++;
            } else {
                r--;
            }
        }
        return c;
    }

    void quicksort(int[] a, int l, int r, int[] b) {
        if (r > l) {
            int p = partition(a, l, r, b);
            quicksort(a, l, p-1, b);
            quicksort(a, p+1, r, b);
        }
    }
    int partition(int[] a, int s, int e, int[] b) {
        // get first low index
        int low = s;
        int p = a[e];
        while(low < e && a[low] > p) {
            low++;
        }
        int i = low + 1;
        while (i<e) {
            // swap it as you see one high, so that high and low can stay together
            if (a[i] >= p) {
                swap (a, low, i, b);
                low++;
            }
            i++;
        }
        // swap low to pivot
        swap(a, e, low, b);
        return low;
    }

    void swap(int[] a, int i, int j, int[] b) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;

        t = b[i];
        b[i] = b[j];
        b[j] = t;
    }

    public static void main(String[] args) {
        System.out.println("P1TwoSum");

        int[] a = {2,7,11,15};
        int t = 9;
        P1TwoSum s = new P1TwoSum();

        int[] val = s.twoSum3(a, t);
        for (int e: val) {
            System.out.print(" "+e);
        }
        System.out.println();
    }
}