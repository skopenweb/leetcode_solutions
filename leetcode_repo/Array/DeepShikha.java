class DeepShikha {

    static class Alphabet {
        char[][] input;

        Alphabet(char[][] input) {
            this.input = input;
        }

        void print() {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].length; j++) {
                    System.out.print(input[i][j]);
                }
                System.out.println();
            }
        }
    }

    static class Printer {
        void print(Alphabet[] ar) {
            for (Alphabet a : ar) {
                a.print();
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        char[][] S = {
                "||======||".toCharArray(),
                "  \\\\    ".toCharArray(),
                "    \\\\  ".toCharArray(),
                "      \\\\".toCharArray(),
                "||======||".toCharArray(),

        };

        char[][] H = {
                "||      ||".toCharArray(),
                "||      ||".toCharArray(),
                "||======||".toCharArray(),
                "||      ||".toCharArray(),
                "||      ||".toCharArray(),
        };

         char[][] I = {
                "|==||==|".toCharArray(),
                "   ||   ".toCharArray(),
                "   ||   ".toCharArray(),
                "   ||   ".toCharArray(),
                "|==||==|".toCharArray(),
        };

         char[][] K = {
                "||   //  ".toCharArray(),
                "||  //   ".toCharArray(),
                "||=-     ".toCharArray(),
                "||  \\\\   ".toCharArray(),
                "||   \\\\  ".toCharArray(),
        };

        char[][] A = {
                "    //\\\\    ".toCharArray(),
                "   //  \\\\   ".toCharArray(),
                "  //====\\\\  ".toCharArray(),
                " //      \\\\ ".toCharArray(),
                "//        \\\\".toCharArray(),
        };
        // Alphabet s = new Alphabet(S);
        // Alphabet h = new Alphabet(H);
        // Alphabet i = new Alphabet(I);
        // Alphabet k = new Alphabet(K);
        // Alphabet a = new Alphabet(A);

        char[][][] lc = {S, H, I, K, H, A};
        System.out.print("\n");

        for (int j=0; j<lc[0].length; j++) {
            for (int j1=0; j1<lc.length; j1++) {
                for (int j2 = 0; j2<lc[j1][j].length; j2++) {
                    System.out.print(lc[j1][j][j2]);
                }
                System.out.print("\t");

            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}