package patterns.number;

                                                //          1
                                                //         232
                                                //        34543
                                                //       4567654
import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }


        public static void print(int n){
            for (int i = 1; i <=n ; i++) {
                int num = i;
                for (int j = 1; j <=n-i ; j++) {
                    System.out.print(" ");
                }
                for (int j  = 1; j <=i ; j++) {
                    System.out.print(num);
                    num++;
                }
                num = num-2;
                for (int j = i; j >=2 ; j--) {
                    System.out.print(num);
                    num--;
                }
                System.out.println();
            }

        }
}
