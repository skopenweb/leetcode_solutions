import java.util.LinkedList;
import java.util.List;

public class P54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int state = 1;
        List<Integer> list = new LinkedList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;
        int total = m * n;
        int i = 0;
        int j = -1;
        int l, r, t, b;
        l = 0;
        t = 1;
        r = n - 1;
        b = m - 1;
        while (count < total) {
            if (state == 1) {
                j++;
                if (j == r) {
                    r--;
                    state = 2;
                }
            } else if (state == 2) {
                i++;
                if (i == b) {
                    b--;
                    state = 3;
                }
            } else if (state == 3) {
                j--;
                if (j == l) {
                    state = 4;
                    l++;
                }
            } else if (state == 4) {
                i--;
                if (i == t) {
                    t++;
                    state = 1;
                }
            }
            list.add(matrix[i][j]);
            count++;
        }

        return list;
    }

    public static void main(String[] args) {
        int [][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> list = new P54SpiralMatrix().spiralOrder(a);
        for (Integer e: list) {
            System.out.print(e+"->");
        }
        System.out.println("END");
    }
}
