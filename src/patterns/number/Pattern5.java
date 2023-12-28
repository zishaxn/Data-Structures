package patterns.number;

import java.util.Scanner;
                                    // 1  2  3  4  4  3  2  1    // no of stars are 2*row.
                                    // 1  2  3  *  *  3  2  1
                                    // 1  2  *  *  *  *  2  1
                                    // 1  *  *  *  *  *  *  1
public class Pattern5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }

  public static void print(int n){
      for (int i = 0; i <n ; i++) {
          for (int j = 1; j <=n-i ; j++) {
              System.out.print(" "+j+" ");
          }
          for (int j = 0; j < 2*i; j++) {
              System.out.print(" "+"*"+" ");
          }
          for (int j = n-i; j >=1 ; j--) {
              System.out.print(" "+j+" ");
          }
          System.out.println();
      }
  }
}
