class Chocolates {
    public long minCost(int[] nums, int x) {
        long cost = 0;
        
        int[] p = new int[nums.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = nums[i];
        }
        boolean remain;
        do {
            int i = 0;
            remain = false;
            int pick = 0;
            while (i < nums.length) {
                if (nums[i] > 0) {
                    if (p[i] < x) {
                        cost += p[i];
                        nums[i] = 0;
                        pick++;
                    } else {
                        remain = true;
                    }
                }
                i++;
            }
            if (remain) {
                int first = nums[0];
                for (int i1=0; i1 < nums.length - 1; i1++) {
                    nums[i1] = nums[i1 + 1];
                }
                nums[nums.length - 1] = first;
                cost += x;
            }
        } while(remain);
        
        return cost;
        
    }

    public long minCost2(int[] nums, int x) {
        long cost = 0;
        int[] c = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            c[i] = nums[i];
        }

        for (int i=1; i<nums.length; i++) {
            int first = nums[0];
            for (int j = 0; j < nums.length - 1; j++) {
                nums[j] = nums[j+1];
                c[j] = Math.min(c[j], x + nums[(j)]);
            }
            nums[nums.length - 1] = first;
            c[nums.length - 1] = Math.min(c[nums.length - 1], x + nums[nums.length - 1]);
        }

        for (int e: c) {
            cost += e;
        }
        return cost;
    }

    public long minCost3(int[] A, int x) {
        int n = A.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] += 1L * i * x;
            int cur = A[i];
            for (int k = 0; k < n; k++) {
                cur = Math.min(cur, A[(i - k + n) % n]);
                res[k] += cur;
            }
        }

        long min_res = Long.MAX_VALUE;
        for (long element : res) {
            min_res = Math.min(min_res, element);
        }

        return min_res;
    }

    public static void main(String[] args) {
        int[] a = {20, 1, 15};
        int[] a1 = {31, 25, 18, 59};

        System.out.println("Min cost:\t"+new Chocolates().minCost(a, 5));
        System.out.println("Min cost:\t"+new Chocolates().minCost2(a1, 27));
        System.out.println("Min cost:\t"+new Chocolates().minCost3(a1, 27));
    }
}