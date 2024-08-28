public class LinkedListSolution {

    private static class ListNode {
        int x;
        ListNode next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int num = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            num++;
        }
        if (num == n) {
            return head.next;
        }
        curr = head;
        for (int i = 1; i < num - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static void main(String[] args) {

    }

}
