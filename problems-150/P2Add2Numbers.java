//   Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P2Add2Numbers {

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // base case : null case
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int c = 0;
        int state = 2;
        ListNode l = l1;
        while (l1 != null) {
            int sum = 0;
            if (state == 2) {
                sum = l1.val + l2.val + c;
                if (sum > 9) {
                    sum -= 10;
                    c = 1;
                } else {
                    c = 0;
                }
                l1.val = sum;
                if (l1.next == null && l2.next == null && c > 0) {
                    l1.next = new ListNode(c, null);
                    break;
                } else if (l1.next == null) {
                    l1.next = l2.next;
                    state = 1;
                } else if (l2.next == null) {
                    state = 1;
                }
            } else if (state == 1) {
                if (c == 0) {
                    break;
                }
                sum = l1.val + c;
                if (sum > 9) {
                    sum -= 10;
                    c = 1;
                } else {
                    c = 0;
                }
                l1.val = sum;
                if (l1.next == null && c > 0) {
                    l1.next = new ListNode(c, null);
                    break;
                }
            }

            if (state == 2) {
                l1 = l1.next;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/add-two-numbers/");
    }
}
