class P36ValidSudoku {
    public boolean isValidSudoku(char[][] b) {
        int N = b.length;
        int[] a; 
        for (int i=0; i<N; i++) {
            a = new int[N];
            for (int j=0; j<N; j++) {
                if (b[i][j] != '.') {
                    int index = b[i][j] - '1';
                    if (a[index]== 0) {
                        a[index]= 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i=0; i<N; i++) {
            a = new int[N]; 
            for (int j=0; j<N; j++) {
                if (b[j][i] != '.') {
                    int index = b[j][i] - '1';
                    if (a[index]== 0) {
                        a[index]= 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        int l = 3;
        int[][] ar = new int[l][l]; 
        for (int i=0; i<N; i += l) {
            for (int j=0; j<N; j+= l) {
                int[][] a1 = new int[l][l];

                for (int i1 = 0; i1<l; i1++) {
                    for (int j1 = 0; j1<l; j1++) {
                        if (b[i+i1][j+j1] != '.') {
                            if (a1[i1][j1]== 0) {
                                a1[i1][j1]= 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] c =  {
        {'.','.','.','.','5','.','.','1','.'},
        {'.','4','.','3','.','.','.','.','.'},
        {'.','.','.','.','.','3','.','.','1'},
        {'8','.','.','.','.','.','.','2','.'},
        {'.','.','2','.','7','.','.','.','.'},
        {'.','1','5','.','.','.','.','.','.'},
        {'.','.','.','.','.','2','.','.','.'},
        {'.','2','.','9','.','.','.','.','.'},
        {'.','.','4','.','.','.','.','.','.'}};
        
        boolean ans = new P36ValidSudoku().isValidSudoku(c);
        System.out.println(ans);

    }
}