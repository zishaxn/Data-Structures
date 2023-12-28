package recursion;

public class FibonacciNumbers_01 {
    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }

    private static int fibonacci(int n) {
        if(n==1 || n==2){
            return 1;
        }
        System.out.println(n);
        return fibonacci(n-2)+fibonacci(n-1);
    }
}
