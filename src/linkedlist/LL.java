package linkedlist;

public class LL {

    //    objects of the class
    private Node head; // The first node in the linked list
    private Node tail; // The last node in the linked list
    private int size;   // The size of the linked list

    // Constructor: Initializes an empty linked list
    public LL() {
        this.size = 0;
    }

//    RECURSION BASED SOLUTIONS

    public void insertRecur(int value, int index) {
        head = insertRecur(value, index, head);
    }

    private Node insertRecur(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }

        node.next = insertRecur(value, index -= 1, node.next);
        return node;

    }


    private void helperInsert(int value, int index, int currIndex, Node temp) {
        if (currIndex != index - 1) {
            helperInsert(value, index, currIndex + 1, temp.next);
            return;
        }
        Node node = new Node(value);
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
        Node node = new Node(value);
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

        Node node = new Node(value);
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

        Node temp = head;
        // Traverse the linked list to find the node at the index - 1 position
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // Create a new node with the given value and set its next to the next of temp
        Node node = new Node(value, temp.next);
        temp.next = node; // Update the next of temp to the new node
        size++;           // Increment the size of the linked list
    }

    // Print the elements of the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void print(Node head) {
        Node temp = head;
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

        Node temp = head;
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
        Node temp = head;
        // Traverse the linked list to find the second-to-last node
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null; // Set the next of the second-to-last node to null
        tail = temp;      // Update the tail to the second-to-last node
        size--;           // Decrement the size of the linked list
    }

    // Node class represents an element in the linked list
    private class Node {
        int val;       // Value of the node
        Node next;       // Reference to the next node
        Node previous;   // Reference to the previous node (not used in your code)

        // Constructor: Initializes a node with the given value
        public Node(int value) {
            this.val = value;
        }

        // Constructor: Initializes a node with the given value and next node
        public Node(int value, Node next) {
            this.val = value;
            this.next = next;
        }

        public Node() {

        }
    }

    /* *****************************************************************************************
     * Below Problems are part of practise problems,
     * they should not be tried to solve before understanding of internal implementation of LL*/
    public Node P1_deleteDuplicates() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public LL P2_mergeTwoLists(Node list1, Node list2) {
        LL ans = new LL();
        Node t1 = head;
        System.out.println(t1);
        Node t2 = head;
        System.out.println(t2);

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                ans.insertLast(t1.val);
                t1 = t1.next;
            } else {
                ans.insertLast(t2.val);
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            ans.insertLast(t1.val);
            t1 = t1.next;
        }
        while (t2 != null) {
            ans.insertLast(t2.val);
            t2 = t2.next;
        }
        return ans;
    }

    public static Node P7_middleNode(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        temp = head;
        for (int i = 0; i < length / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static Node P7_middleNode2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //    using recursion and tail
    public Node P8_reverseLinkedList(Node node) {
        if (node == tail) {
            head = tail;
            return head;
        }

        head = P8_reverseLinkedList(node.next);
//         Ek hi node hai jo hai 1--> null // ye hi tail bhi hai head bhi hai
        tail.next = node; // 1--> 2
        tail = node;     // (head)1-->2 (tail)
        tail.next = null;   // 1--> 2 --> |0|

        return head;
    }


    //    using loop and without tail
    public Node P8_reverseLinkedList2(Node node) {
        if (node == null) {
            return null;
        }
        Node prev = null;
        Node present = node;
        Node next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public Node P10_reverseBetween(Node node, int left, int right) {
        Node head = node;
        // Create a dummy node to handle cases where left = 1
        Node dummy = new Node(0);
        dummy.next = node;

        // Find the nodes at positions left-1 and right
        Node start = dummy;
        Node end = dummy;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        System.out.println(start.val);
        for (int i = 0; i < right; i++) {
            end = end.next;
        }

        // Store the next node of the right end
        Node temp = end.next;
        end.next = null;

        // Reverse the sublist from start.next to end
        Node reversedSublist = P8_reverseLinkedList2(start.next);

        // Connect the reversed sublist to the original list
        start.next = reversedSublist;

        // Find the end of the reversed sublist
        Node reversedEnd = reversedSublist;
        while (reversedEnd.next != null) {
            reversedEnd = reversedEnd.next;
        }

        // Connect the end of the reversed sublist to the node after the right end
        reversedEnd.next = temp;

        return dummy.next; // Return the head of the modified list
    }

    public boolean isPalindrome(Node head) {

        if(head==null || head.next==null || head.next.next==null){
            return false;
        }
        Node mid = P7_middleNode2(head);
        Node reversedSecondList = P8_reverseLinkedList2(mid);

        print(reversedSecondList);
        print(head);
        while(head!=null && reversedSecondList!=null){
            if(head.val!=reversedSecondList.val){
                return false;
            }
            head=head.next;
            reversedSecondList=reversedSecondList.next;
        }
        return true;
    }

    public static void main(String[] args) {

        LL l1 = new LL();
        l1.insert(0, 1);
        l1.insert(1, 2);
        l1.insert(2, 3);
        l1.insert(3, 4);
        l1.insert(4, 1);

        System.out.println(l1.isPalindrome(l1.head));






    }
}
