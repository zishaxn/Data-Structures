package patterns.star;

import java.util.Scanner;

                                                            //*
                                                            //* *
                                                            //* * *
                                                            //* * * *
                                                            //* * * * *
                                                            //* * * *
                                                            //* * *
                                                            //* *
                                                            //*

public class Pattern4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        System.out.println("Enter Number of row");
//        int n = s.nextInt();
//        System.out.println("HELLO");
        print(5);

    }

    public static void  print(int n) {
        for (int row = 0; row <2*n ; row++) {

            int cols = row > n ? 2 * n - row: row;
            for (int i = 0; i < cols; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
