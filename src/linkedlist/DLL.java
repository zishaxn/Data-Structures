package linkedlist;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL(){
        this.size=0;
    }

    public void getSize(){
        System.out.println("size: "+size);
    }
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next=head;
        node.previous=null;
        if(head!=null){
            head.previous=node;
        }
        head=node;

        if(tail==null){
            tail=head;
            tail.previous=head.previous;
        }
        size+=1;
    }
    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        node.previous=tail;
        tail.next=node;
        tail=node;
        size+=1;
    }

    public void insert(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }

        if(index>size || index<0){
            System.out.println("Cant Add "+value+" At "+index+" Index! Enter a valid index");
            return;
        }

        Node temp = head;
        for (int i = 0; i <index-1 ; i++) {
            temp=temp.next;
        }

        Node node = new Node(value,temp.next);
        temp.next.previous=node;
        node.previous=temp;
        temp.next=node;
        size++;
    }
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" --> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public void printReverse(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.value+" --> ");
            temp=temp.previous;
        }
        System.out.println("START");
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.println("START");
    }

    public void delete(int index){
        if(index==0){
            deleteFirst();
            return;
        }
        if(index==size-1){
            deleteLast();
            return;
        }
        Node temp = head;
        for (int i = 0; i <index-1 ; i++) {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }

    public void deleteFirst(){

        Node temp = head.next;
        if(head.next!=null){
            head.next.previous=null;
        }
        assert temp != null;
        head=temp;
        size--;
    }

    public void deleteLast(){
        Node temp = head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }
    private class Node{
        int value;
        Node next;
        Node previous;
        public Node (int value){
            this.value=value;
        }

        public Node (int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
}
