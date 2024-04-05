import java.util.*;

class P3LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int maxLen = 0;

        int l = 0;
        int r = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            if (m.containsKey(c)) {
                char c1;
                do {
                    c1 = s.charAt(l);                
                    m.remove(c1);
                    ++l;
                } while (c1 != c);
            } else {
                // no match
                m.put(c, 1);
                r++;

                if (r - l > maxLen) {
                    maxLen = r-l;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        P3LongestSubstring s =  new P3LongestSubstring();
        System.out.println(s.lengthOfLongestSubstring("abcdefcde"));
    }
}