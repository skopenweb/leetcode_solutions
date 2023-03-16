import java.util.Arrays;

public class Dups {

    public static int duplicates(int[] arr) {
        int l = 0;
        int r = l+1;

        while(r < arr.length) {
            if (arr[l] != arr[r]) {
                l++;
                arr[l] = arr[r];
            }
            r++;
        }
        return 0;
    }

    public static int duplicates2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int curr = 1;
        while (curr < nums.length && nums[curr] != nums[curr-1]) {
            curr++;
        }
        
        int prev = curr - 1;
        while (curr < nums.length) {
            if (nums[curr] != nums[prev]) {
                nums[++prev] = nums[curr];
            }
            curr++;
        }
        return prev+1;
    }

    public static void main(String[] args) {
        System.out.println("Duplicates numbers");
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Input:\t"+ Arrays.toString(a));
        duplicates2(a);
        System.out.println("Output:\t"+ Arrays.toString(a));

    }
}