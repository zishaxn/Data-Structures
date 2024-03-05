package linkedlist;

public class LinkedList {

    //    objects of the class
    public ListNode head; // The first node in the linked list
    public ListNode tail; // The last node in the linked list
    public int size;   // The size of the linked list

    // Constructor: Initializes an empty linked list
    public LinkedList() {
        this.size = 0;
    }

//    RECURSION BASED SOLUTIONS

    public void insertRecur(int value, int index) {
        head = insertRecur(value, index, head);
    }

    private ListNode insertRecur(int value, int index, ListNode node) {
        if (index == 0) {
            ListNode temp = new ListNode(value, node);
            size++;
            return temp;
        }

        node.next = insertRecur(value, index -= 1, node.next);
        return node;

    }


    private void helperInsert(int value, int index, int currIndex, ListNode temp) {
        if (currIndex != index - 1) {
            helperInsert(value, index, currIndex + 1, temp.next);
            return;
        }
        ListNode node = new ListNode(value);
        if (index == 0) {
            insertFirst(value);
            return;
        }

        // If index is equal to the size, call insertLast to handle the insertion
        if (index == size) {
            insertLast(value);
            return;
        }

        node.next = temp.next;
        temp.next = node;
        size++;

    }


//    Methods of the class

    // Print the size of the linked list
    public void getSize() {
        System.out.println("size: " + size);
    }

    // Insert a new node with the given value at the beginning of the linked list
    public void insertFirst(int value) {
        ListNode node = new ListNode(value);
        node.next = head; // Set the next of the new node to the current head
        head = node;      // Update the head to the new node

        // If the linked list was empty, set the tail to the new node as well
        if (tail == null) {
            tail = head;
        }

        size += 1; // Increment the size of the linked list
    }

    // Insert a new node with the given value at the end of the linked list
    public void insertLast(int value) {
        // If the linked list is empty, call insertFirst to handle the insertion
        if (tail == null) {
            insertFirst(value);
            return;
        }

        ListNode node = new ListNode(value);
        tail.next = node; // Set the next of the current tail to the new node
        tail = node;      // Update the tail to the new node
        size += 1;        // Increment the size of the linked list
    }

    // Insert a new node with the given value at the specified index in the linked list
    public void insert(int index, int value) {
        // If index is 0, call insertFirst to handle the insertion
        if (index == 0) {
            insertFirst(value);
            return;
        }

        // If index is equal to the size, call insertLast to handle the insertion
        if (index == size) {
            insertLast(value);
            return;
        }

        ListNode temp = head;
        // Traverse the linked list to find the node at the index - 1 position
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // Create a new node with the given value and set its next to the next of temp
        ListNode node = new ListNode(value, temp.next);
        temp.next = node; // Update the next of temp to the new node
        size++;           // Increment the size of the linked list
    }

    // Print the elements of the linked list
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Delete the node at the specified index in the linked list
    public void delete(int index) {
        // If index is 0, call deleteFirst to handle the deletion
        if (index == 0) {
            deleteFirst();
            return;
        }

        // If index is equal to size-1, call deleteLast to handle the deletion
        if (index == size - 1) {
            deleteLast();
            return;
        }

        ListNode temp = head;
        // Traverse the linked list to find the node at the index - 1 position
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // Update the next of temp to skip the node to be deleted
        temp.next = temp.next.next;
        size--; // Decrement the size of the linked list
    }

    // Delete the first node in the linked list
    public void deleteFirst() {
        head = head.next; // Update the head to the next node
        size--;           // Decrement the size of the linked list
    }

    // Delete the last node in the linked list
    public void deleteLast() {
        ListNode temp = head;
        // Traverse the linked list to find the second-to-last node
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null; // Set the next of the second-to-last node to null
        tail = temp;      // Update the tail to the second-to-last node
        size--;           // Decrement the size of the linked list
    }

    // ListNode class represents an element in the linked list
    private class ListNode {
        int val;       // Value of the node
        ListNode next;       // Reference to the next node
        ListNode previous;   // Reference to the previous node (not used in your code)

        // Constructor: Initializes a node with the given value
        public ListNode(int value) {
            this.val = value;
        }

        // Constructor: Initializes a node with the given value and next node
        public ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }

        public ListNode() {

        }
    }


//  ******************** Problems **********************/////////

    //    problem 1
//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    //    problem 2
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ans = new ListNode(0);
        ListNode t3 = ans;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t3.next = t1;
                t1 = t1.next;
                t3 = t3.next;
            } else {
                t3.next = t2;
                t2 = t2.next;
                t3 = t3.next;
            }
        }

        while (t1 != null) {
            t3.next = t1;
            t1 = t1.next;
            t3 = t3.next;
        }
        while (t2 != null) {
            t3.next = t2;
            t2 = t2.next;
            t3 = t3.next;
        }

        return ans.next;
    }


    //    problem 3
//    https://leetcode.com/problems/sort-list
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeTwoLists(left, right);
    }

    // problem 4
//    https://leetcode.com/problems/reverse-linked-list
    public ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }

        ListNode prev = null;
        ListNode current = node;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev; // updating the head to the last node
        return prev;
    }

    //    problem 5
//    https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //    problem 6
//    https://leetcode.com/problems/palindrome-linked-list
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode reversedHead = reverseList(mid);

        while (head != null && reversedHead != null) {
            if (head.val != reversedHead.val) {
                return false;
            }
            head = head.next;
            reversedHead = reversedHead.next;
        }

        return true;
    }
}