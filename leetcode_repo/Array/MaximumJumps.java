class MaximumJumps {
    public int maximumJumps(int[] nums, int target) {
        // jump(s) => max(jump(s+1..N-1)) + 1; follows: | sum(s+j) - sum(s)| < target
        int[] dp = new int[nums.length];
        return jump(0, nums, target, nums[0], dp);
    }
    
    private int jump (int start, int[] arr, int target, int prev, int[] dp) {
        if (Math.abs(arr[start] - prev) > target) return -1;
        if (start == arr.length - 1) return 0;
        if (dp[start] != 0) return dp[start];

        int max = -1;
        for (int i = start + 1; i<arr.length; i++) {
            int curr = jump(i, arr, target, arr[start], dp);
            if (max < curr) max = curr;
        }
        dp[start] = max == -1 ? max : max + 1;
        return dp[start];
    }

    // public int maximumJumps(int[] nums, int target) {
    //     int[] dp = new int[nums.length];
    //     return max(nums, 0, nums.length -1, dp, target);
    // }
    
    // private int max(int[] nums, int s, int e, int[] dp, int t) {
    //     if (s == e) {
    //         return 0;
    //     }
        
    //     if (dp[s] > 0 ) {
    //         return dp[s];
    //     }
    //     int max = 0;
    //     for (int j=s+1; j<e; j++) {
    //         int curr = 1;
    //         if (mod(nums[j] - nums[s]) <= t) {
    //             curr += max(nums, j, e, dp, t);
    //         }
    //         if (curr > max) max = curr;
    //     }
        
    //     dp[s] = max;
        
    //     return max;
    // }
    
    // int mod(int n) { return n > 0 ? n : -n;}

    public static void main(String[] args) {
        int[] ar = {1,3,6,4,1,2};
        int t = 3;
        System.out.println("MaxJump = "+new MaximumJumps().maximumJumps(ar, t));
        
    }
}