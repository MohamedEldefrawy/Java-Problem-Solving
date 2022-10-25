package linkedlist;

public class RemoveDuplicatesFromSortedLinkedList {
    public static class ListNode {
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

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        while (left != null) {
            if (right.next == null) {
                left = left.next;
                right = left;
                continue;
            }

            if (left.val == right.next.val) {
                right.next = right.next.next;
            } else {
                right = right.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(3, new ListNode(1, null)))));

        ListNode result = deleteDuplicates(node);
        System.out.println(result.val);
        System.out.println(result.next.val);
    }
}
