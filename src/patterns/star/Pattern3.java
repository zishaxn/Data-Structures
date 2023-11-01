package patterns.star;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();

        print1(n);
        System.out.println();
        print22(n);
    }



    public static void print1(int n) {
            for (int mainRow = 1; mainRow <= (n / 2) + 1; mainRow++) {
                // This tells us the number of spaces to give.
                for (int spaces = 1; spaces <= (n / 2) + 1 - mainRow; spaces++) {
                    System.out.print(" ");
                }

                // This tells us the number of stars for current row.
                for (int currCol = 1; currCol <=(2 * mainRow) - 1; currCol++) {
                    System.out.print("*");
                }

                System.out.println();
            }

            // Lower Half.
            for (int mainRow = 1; mainRow <= n / 2; mainRow++) {
                // This tells us the number of spaces to give.
                for (int spaces = 1; spaces <= mainRow; spaces++) {
                    System.out.print(" ");
                }

                int currCol = 2 * ((n / 2) - mainRow + 1) - 1;

                // This tells us the number of stars for the current row.
                for (int i = 1; i <= currCol; i++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }


    public static void print22(int n){
        for (int row = 1; row <=2*n-1 ; row++) {
            int spaces = Math.abs(n-row);

            for (int space = 1; space <= spaces; space++) {
                System.out.print(" ");
            }

            int stars = 2*n-spaces*2-1;
            for (int star = 1; star <=stars ; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}


