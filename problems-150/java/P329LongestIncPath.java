class P329LongestIncPath {

    public int longestIncreasingPath(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[][] cache = new int[M][N];
        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (cache[i][j] == 0) {
                    int currMax = dfs(i, j, -1, matrix, cache);
                    if (currMax > max) {
                        max = currMax;
                    }
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int prev, int[][] m, int[][] cache) {
        if (i < 0 || i >= m.length) {
            return 0;
        }
        if (j < 0 || j >= m[0].length) {
            return 0;
        }
        int curr = m[i][j];
        if (curr <= prev) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int maxx = 0;
        int top = dfs(i-1, j, curr, m, cache);
        int bottom = dfs(i+1, j, curr, m, cache);
        int left = dfs(i, j-1, curr, m, cache);
        int right = dfs(i, j+1, curr, m, cache);

        if (top > maxx) {
            maxx = top;
        }
        if (bottom > maxx) {
            maxx = bottom;
        }
        if (left > maxx) {
            maxx = left;
        }
        if (right > maxx) {
            maxx = right;
        }
        cache[i][j] = maxx + 1;
        return cache[i][j];
    }
    
    public static void main(String[] args) {
        int [][] m = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new P329LongestIncPath().longestIncreasingPath(m));
    }
}
