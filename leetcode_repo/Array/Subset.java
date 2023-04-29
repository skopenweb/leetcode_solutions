class Subset {

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 6, 8, 10};
        int[] selection = new int[a.length];

        subset(a, selection, 0, 10);
        System.out.println("Find all the subset");
    }

    private static int subset(int[] a, int[] selection, int index, int sum) {
        if (index >= a.length || sum < 0) {
            return 0;
        }
        if (sum == 0) {
            print(a, selection);
            return 1;
        }

        int c1 = subset(a, copyOf(selection), index+1, sum);
        
        int[] selection2 = copyOf(selection);
        selection2[index] = 1;
        int c2 = subset(a, selection2, index+1, sum - a[index]);
        return c1 + c2;
    }

    private static void print(int[] a, int[] selection) {
        System.out.print("{");
        for (int i=0; i<a.length; i++) {
            if (selection[i] == 1) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println("}");        
    }

    private static int[] copyOf(int[] a) {
        int[] b = new int[a.length];
        for (int i=0; i<a.length; i++) {
            b[i] = a[i];
        }

        return b;
    }
}