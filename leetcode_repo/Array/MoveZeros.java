import java.util.Arrays;

class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length && nums[i] != 0) {
            i++;
        }

        int curr = i + 1;
        while (curr < nums.length) {
            if (nums[curr] != 0) {
                swap(nums, i, curr);
                i++;
            }
            curr++;
        }
    }

    public void moveZeroes2(int[] a) {
        int i = 0;
        int j = 0;

        while (j< a.length) {
            if (a[j] != 0) {
                a[i] = a[j];
                i++;
            }
            j++;
        }

        while (i < a.length) {
            a[i++] = 0;
        }
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println("MoveZeros");
        int[] a = {0,1,0,3,12};
        System.out.println("Input:\t"+ Arrays.toString(a));
        s.moveZeroes(a);
        s.moveZeroes2(a);
        System.out.println("Output:\t"+ Arrays.toString(a));
    }
}