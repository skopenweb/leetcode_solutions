public class P73SetMatrixZeros {
    public static void main(String[] args) {
        System.out.println("Set Matrix Zeros");

        int[][] m = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new P73SetMatrixZeros().setZeroes(m);


        System.out.print("Final\n[");
        for (int i=0; i<m.length; i++) {
            System.out.print("[");
            for (int j=0; j < m[0].length; j++) {
                System.out.print(" "+ m[i][j]);
            }
            System.out.print("]");
        }
        System.out.println("]");

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        System.out.print("[");
        for (int i=0; i<m; i++) {
            System.out.print("[");
            for (int j=0; j < n; j++) {
                System.out.print(" "+ matrix[i][j]);
            }
            System.out.print("]");
        }
        System.out.println("]");

        for (int i=1; i<m; i++) {
            for (int j=1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}