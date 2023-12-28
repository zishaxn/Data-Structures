package patterns.star;

import java.util.Scanner;


//    *
//   ***
//  *****
// *******

//Approach:
/*
* In diamond of start first we take care of blank spaces before the star
* and then the start and then the starts that are mirror image.*/



public class Pattern2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }

    public static void print(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//    public static void print(int n){
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=n-i ; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <=2*i-1 ; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
}
