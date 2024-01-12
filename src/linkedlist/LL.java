package linkedlist;

public class LL {

//    objects of the class
    private Node head; // The first node in the linked list
    private Node tail; // The last node in the linked list
    private int size;   // The size of the linked list

    // Constructor: Initializes an empty linked list
    public LL(){
        this.size = 0;
    }


//    Methods of the class

    // Print the size of the linked list
    public void getSize(){
        System.out.println("size: " + size);
    }

    // Insert a new node with the given value at the beginning of the linked list
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head; // Set the next of the new node to the current head
        head = node;      // Update the head to the new node

        // If the linked list was empty, set the tail to the new node as well
        if(tail == null){
            tail = head;
        }

        size += 1; // Increment the size of the linked list
    }

    // Insert a new node with the given value at the end of the linked list
    public void insertLast(int value){
        // If the linked list is empty, call insertFirst to handle the insertion
        if(tail == null){
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node; // Set the next of the current tail to the new node
        tail = node;      // Update the tail to the new node
        size += 1;        // Increment the size of the linked list
    }

    // Insert a new node with the given value at the specified index in the linked list
    public void insert(int value, int index){
        // If index is 0, call insertFirst to handle the insertion
        if(index == 0){
            insertFirst(value);
            return;
        }

        // If index is equal to the size, call insertLast to handle the insertion
        if(index == size){
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
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Delete the node at the specified index in the linked list
    public void delete(int index){
        // If index is 0, call deleteFirst to handle the deletion
        if(index == 0){
            deleteFirst();
            return;
        }

        // If index is equal to size-1, call deleteLast to handle the deletion
        if(index == size - 1){
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
    public void deleteFirst(){
        head = head.next; // Update the head to the next node
        size--;           // Decrement the size of the linked list
    }

    // Delete the last node in the linked list
    public void deleteLast(){
        Node temp = head;
        // Traverse the linked list to find the second-to-last node
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null; // Set the next of the second-to-last node to null
        tail = temp;      // Update the tail to the second-to-last node
        size--;           // Decrement the size of the linked list
    }

    // Node class represents an element in the linked list
    private class Node{
        int value;       // Value of the node
        Node next;       // Reference to the next node
        Node previous;   // Reference to the previous node (not used in your code)

        // Constructor: Initializes a node with the given value
        public Node (int value){
            this.value = value;
        }

        // Constructor: Initializes a node with the given value and next node
        public Node (int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
