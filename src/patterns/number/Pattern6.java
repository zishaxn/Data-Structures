package patterns.number;

                                                    //4555
                                                    //3455
                                                    //2345
                                                    //1234
import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }

    public static void print(int n) {
        for (int i = n; i >=1 ; i--) {
            int num = i;
            int j;
            for ( j = 0; j < n-i+1; j++) {
                System.out.print(num);
                num++;
            }
            for ( int k = j ; k<n ; k++) {
                System.out.print(5);
            }
            System.out.println();
        }
    }
}
