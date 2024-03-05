package linkedlist;

public class CLL {
    private Node head;
    private Node tail;

    private int size;

    public CLL(){
        this.size=0;
    }

    public void insertStart(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = head;
            size += 1;
            return;
        }
        node.next = head;
        head = node;
        tail.next = head;
        size += 1;
    }

    public void insertEnd(int value) {
        Node node = new Node(value);
        // Update the next reference of the tail to head
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = head; // Update the next reference of the tail to head
        size++;
    }

    public void insert(int value, int index) {
        // If index is 0, call insertFirst to handle the insertion
        if (index == 0) {
            insertStart(value);
            return;
        }

        // If index is equal to the size, call insertLast to handle the insertion
        if (index == size) {
            insertEnd(value);
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

    public void getSize() {
        System.out.println("size: " + size);
    }


    //    deletion
    public void deleteFirst() {
        head = head.next;
        tail.next = head;
        size -= 1;
    }

    public void deleteLast() {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = head;
        size -= 1;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
       Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public  void print(Node head) {
        Node temp = head;
        System.out.print("START --> ");
        int count = 0;
        while (temp != null && count <= 2 * size) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
            count++;
            if (temp == head) {
                System.out.print("(cycle starts here) --> ");
                while (temp.next != head) {
                    temp = temp.next;
                }
                System.out.print(temp.value + " --> ");
                break;
            }
        }
        if (temp == null) {
            System.out.println("END (no cycle)");
        } else {
            System.out.println("(cycle)");
        }
    }
//    additional methods in cycle


    public void createCycle(int index) {
        if (index >= size) {
            return; // Index out of bounds, cannot create cycle
        }
        Node temp = head;
        Node cycleStart = null;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            if (i == index - 1) {
                cycleStart = temp; // Remember the node where the cycle starts
            }
        }
        tail.next = cycleStart; // Create cycle by connecting tail to the starting node of the cycle
    }


//    https://leetcode.com/problems/linked-list-cycle/
    public boolean P3_hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public int P4_lengthOfCycle(Node startNode) {
        Node slow = startNode;
        Node fast = startNode;

        int length = 0;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        do {
            slow = slow.next;
            length += 1;
        } while (slow != fast);
        return length;
    }

//    https://leetcode.com/problems/linked-list-cycle-ii
    public Node P5_startOfCycle(Node head){
        Node slow = head;
        Node fast = head;

        do{
            slow=slow.next;
            fast=fast.next.next;
        }while (slow!=fast);
        fast = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }

//https://leetcode.com/problems/happy-number/
    public static boolean P6_isHappy(int n ){
        int fast = n;
        int slow = n;
        do{
            slow= findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while (fast!=slow);

        return slow==1;
    }

    private static int findSquare(int num) {
        int sum = 0;
        while (num>0){
            int rem = num%10;
            sum+=rem*rem;
            num/=10;
        }
        return sum;
    }

    public class Node{
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        CLL l1 = new CLL();
        l1.insertStart(1);
        l1.createCycle(0);
        l1.print(l1.P5_startOfCycle(l1.head));







    }
}
