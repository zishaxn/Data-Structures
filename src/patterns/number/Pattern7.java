package patterns.number;

import java.util.Scanner;

                                            //     1
                                            //    12
                                            //   123
                                            //  1234
public class Pattern7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }

    public static void print(int n) {
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
