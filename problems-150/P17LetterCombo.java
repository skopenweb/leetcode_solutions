import java.util.*;

class P17LetterCombo {
    public static void main(String[] args) {
        
        for (String s: letterCombinations("23")) {
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        int size = digits.length();
        char[][] cset = new char[size][];

        List<String> ll = new ArrayList<String>();

        // initialization: set mapping of characters
        int start = 0;
        int[] selection = new int[size];
        for (int i=0; i<size; i++) {
            cset[i] = range(digits.charAt(i));
        }
        combWords(cset, selection, start, ll);
        return ll;
    }

    static void combWords(char[][] set, int[] selection, int start, List<String> ll) {
        if (start == set.length) {
            ll.add(formWord(set, selection));
            return;
        }

        int currLength = set[start].length;

        for (int i=0; i<currLength; i++) {
            selection[start] = i;
            combWords(set, selection, start+1, ll);
        }
    }

    static String formWord(char[][] set, int[] selection) {
        char[] out = new char[selection.length];

        for (int i=0; i<set.length; i++) {
            out[i] = set[i][selection[i]];
        }
        return new String(out);
    }

    static char[] range(char digit) {

        char s;
        char[] out = {};
        if (digit > '1' && digit < '7') {
            int val = (digit - '2') * 3;
            s = (char)('a' + val);
            out = new char[]{(char)s, (char)(++s), (char)(++s)};
        } else if (digit == '7') {
            s = 'p';
            out = new char[]{(char)s, (char)(++s), (char)(++s), (char)(++s)};
        } else if (digit == '8') {
            s = 't';
            out = new char[]{(char)s, (char)(++s), (char)(++s)};
        } else if (digit == '9') {
            s = 'w';
            out = new char[]{(char)s, (char)(++s), (char)(++s), (char)(++s)};
        }
        return out;
    }

    static char[] range(int digit) {
        char s;
        char[] out = {};
        if (digit > 1 && digit < 7) {
            int val = (digit - 2) * 3;
            s = (char) ('a' + val);
            out = new char[]{(char)s, (char)(++s), (char)(++s)};
        } else if (digit == 7) {
            s = 'p';
            out = new char[]{(char)s, (char)(++s), (char)(++s), (char)(++s)};
        } else if (digit == 8) {
            s = 't';
            out = new char[]{(char)s, (char)(++s), (char)(++s)};
        } else if (digit == 9) {
            s = 'w';
            out = new char[]{(char)s, (char)(++s), (char)(++s), (char)(++s)};
        }
        return out;
    }
}