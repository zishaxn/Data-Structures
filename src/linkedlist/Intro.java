package linkedlist;

public class Intro {
    public static void main(String[] args) {

        LinkedList  l1 = new LinkedList();
        l1.insert(0, 1);
        l1.insert(1, 2);
//        l1.insert(2, 4);
//        l1.insert(3, 3);
//        l1.insert(4, 1 );

        l1.print();
        System.out.println(l1.isPalindrome(l1.head));



    }
}
