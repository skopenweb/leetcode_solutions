import java.util.Arrays;

class P2KthShortest {
    public static void main(String[] args) {

        P2KthShortest l = new P2KthShortest();
        int[] arr = {62, 100, 4};

        System.out.println("PKth "+        smallestDistancePair(arr, 3));

    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;

        int currMin = Integer.MAX_VALUE;
        int min = 0;

        while (r < nums.length) {
            if (r-l < k - 1) {
                r++;
            } else {
                min = nums[r] - nums[l];
                if (currMin > min) {
                    currMin = min;
                }
                l++;
                r++;
            }
        }
        return currMin;
    }
}