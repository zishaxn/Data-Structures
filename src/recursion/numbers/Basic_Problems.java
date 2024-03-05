package recursion.numbers;

public class Basic_Problems {
    public static void main(String[] args) {
        // Fibonacci example
        System.out.println("8th Fibonacci Number is " + fibonacciNum(8));

        // PrintNums example (commented out to avoid potential StackOverflowError)
        // PrintNumsExample.printNums(5);

        // Factorial example
        System.out.println("Factorial of first 5 Numbers is " + fact(5));

        // SumOfNums example
        System.out.println("Sum of first 5 Numbers is " + sumOfNums(5));

        // NumOfDigits example
        System.out.println("Num of Digits in 452 is " + numOfDigits(45452));

        // SumOfDigits example
        System.out.println("Sum of Digits in 452 is " + sumOfDigits(452));

        // Print nums
        printNums(10);
    }

    public static int fibonacciNum(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacciNum(n - 2) + fibonacciNum(n - 1);
    }
    public static void printNums(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNums(n - 1);
    }

    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int sumOfNums(int n) {
        if (n <= 1) {
            return 1;
        }
        return n + sumOfNums(n - 1);
    }

    public static int numOfDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + numOfDigits(n / 10);
    }

    public static int sumOfDigits(int n) {
        if (n / 10 == 0) {
            return n;
        }
        return n % 10 + sumOfDigits(n / 10);
    }


}
