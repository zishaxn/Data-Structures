package patterns.characters;

import java.util.Scanner;

//A
                                                // BB
                                                // CCC
public class Pattern1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }

    public static void print(int n) {
        char ch = 'A';
        for (int i = 0; i <n ; i++) {
            ch+=i;
            for (int j = 0; j <=i; j++) {
                System.out.print(ch);
               ch+=1;
            }
            ch='A';

            System.out.println();
        }
    }
}
