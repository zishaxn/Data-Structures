package patterns.number;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
//        int n = s.nextInt();
        print(4);
    }


    public static void print(int n){
        for (int i = n; i >0 ; i--) {
            int num = i;
            for (int j = 1; j <=n-i+1 ; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
}
