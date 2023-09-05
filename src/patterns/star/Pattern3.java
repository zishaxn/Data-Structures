package patterns.star;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print2(n);
        System.out.println("***************************************");
//        print(n);
    }

    public static void print2(int n){
        for (int i = 1; i <=n/2+1 ; i++) {

//            for spaces
            for (int j = 1; j <n/2+1-i ; j++) {
                System.out.print(" ");
            }
//            for stars
            for (int j = 1; j <(2*i)-i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
















    public static void print(int n){
        for (int i = 1; i <=(n/2)+1 ; i++) {
            for (int j = 1; j <=n/2+1-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=(2*i)+1-i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <=(n/2) ; i++) {
            for (int j = 1; j <=n/2+1-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=(2*i)-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    public static void print1(int n) {
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println(); // Move to the next line after each row
        }

        for (int i = n - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println(); // Move to the next line after each row
        }
    }

}


