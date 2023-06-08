public class P62UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        return find(m, n, cache);
    }

    int find(int m, int n, int[][] cache) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        int total = cache[m][n];
        if (total > 0) {
            return total;
        }
        int l = find(m - 1, n, cache);
        int r = find(m, n - 1, cache);

        total = l + r;
        cache[m][n] = total;

        return total;
    }

    public static void main(String[] args) {
        System.out.println("Unique path "+ new P62UniquePath().uniquePaths(20, 20));
    }
}
