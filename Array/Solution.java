public class Solution {

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

    public int duplicates2(int[] nums) {
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

    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int currMin = nums[0];
        int currDiff = -1;

        for (int i = 1; i<nums.length; i++) {
            if (nums[i] < currMin) {
                currMin = nums[i];
            } else {
                int diff = nums[i] - currMin;
                if (diff > 0 && diff > currDiff) {
                    currDiff = diff;
                }
            }
        }
        return currDiff;
    }

    public static void main(String[] args) {
        
    }
    
}
