package patterns.number;


import java.util.Scanner;

//4444
//4444
//4444
//4444
public class Pattern1 {

    public static void print(int n){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(4);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of row");
        int n = s.nextInt();
        print(n);
    }
}
