import java.util.HashMap;
import java.util.Map;

public class P279PerfectSquares {
    public int numSquares(int n) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return minSquareNum(n, cache);
    }

    int minSquareNum(int sum, Map<Integer, Integer> cache) {
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return Integer.MAX_VALUE;
        }
        if (cache.containsKey(sum)) {
            return cache.get(sum);
        }
        int min = Integer.MAX_VALUE;
        int i = 1;
        while (true) {
            int ii = i * i;
            if (ii > sum) {
                break;
            }
            int curr = 1 + minSquareNum(sum - ii, cache);
            if (curr < min) {
                min = curr;
            }
            i++;
        }
        cache.put(sum, min);
        return min;
    }

}
