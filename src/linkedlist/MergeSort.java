package linkedlist;

public class MergeSort {
    public static void main(String[] args) {
        LL l1 = new LL();
        l1.insertLast(5);
        l1.insertFirst(3);
        l1.insertLast(7);
        l1.insertFirst(0);
        l1.insertLast(1);
        LL l2 = new LL();
        l2.insertLast(6);
        l2.insertFirst(4);
        l2.insertLast(8);
        l2.insertFirst(2);
        l2.insertLast(6);



    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        return merge(list1, list2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode = new ListNode(0);
        ListNode head = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }
        return newNode.next;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public class ListNode {
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
}
