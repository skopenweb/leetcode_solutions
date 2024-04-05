import java.util.Arrays;

public class P41MissingPos {
    public int firstMissingPositive(int[] nums) {
        int posLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = -1;
                posLen++;
            }
        }
        posLen = nums.length - posLen;
        System.out.println("positive length: "+ posLen);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int j = nums[i];
                while (true) {
                    if (j <= 0 || j > posLen) {
                        break;
                    }
                    j--;
                    int t = nums[j];
                    nums[j] = 0;
                    j = t;
                }
            }
        }

        System.out.println("after traversal "+ Arrays.toString(nums));

        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        System.out.println("find first non-visited element "+ Arrays.toString(nums));
        return ++i;
    }
    public static void main(String[] args) {
        int[] a = { 4,2,0,1,4 };
        System.out.println("Missing Positive number = " + new P41MissingPos().firstMissingPositive(a));
    }
}