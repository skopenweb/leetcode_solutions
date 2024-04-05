
public class P5LongPalindrome {

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i + max.length(); j--) {
                boolean isPal = isPalindrome(s, i , j);
                if (isPal) {
                    if (j - i + 1 > max.length()) {
                        max = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return max;
    }

    boolean isPalindrome(String in, int a, int b) {
        boolean isPalindrome  = true;
        while(a < b) {
            if (in.charAt(a) != in.charAt(b)) {
                isPalindrome = false;
                break;
            }
            a++;
            b--;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println("P5LongPalindrome.java");
        String a = "babad";
        System.out.println(new P5LongPalindrome().longestPalindrome(a));
    }
}