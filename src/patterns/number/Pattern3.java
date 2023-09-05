package patterns.number;

import java.util.Scanner;

//1
                                //21
                                //321
                                //4321
public class Pattern3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }

    public static void print(int n) {
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
