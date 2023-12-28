package recursion.misc;

public class PrintFactorial {
    public static void main(String[] args) {
        System.out.println(factorial1(5));
        factorial(5,1);
        int[]arr = {5,4,3,2,11};
        minimum(arr,0,Integer.MAX_VALUE);
        System.out.println(minimum(arr,0));
    }

    //This Method returns the factorial of given number.
    public static int factorial1(int n){
        if(n==0){
            return 1;
        }
        return n*factorial1(n-1);
    }

    //This Method Prints the factorial of given number.
    public static void factorial(int n,int ans){
        if(n==0){
            System.out.println(ans);
            return;
        }
        ans=ans*n;
       factorial(n-1,ans);
    }

    //This Method will print minimum element in Array
    public static void minimum(int[]arr,int si,int min){
        if(si==arr.length){
            System.out.println(min);
            return;
        }
        min=Math.min(arr[si],min);
        minimum(arr,si+1,min);
    }

    //This Method will return minimum element in Array
    public static int minimum(int[]arr,int si){
        if(si== arr.length){
            return Integer.MAX_VALUE;
        }
        int small=minimum(arr,si+1);
        return Math.min(small,arr[si]);
    }

}
