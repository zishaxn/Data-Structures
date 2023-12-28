package recursion;

public class Intro {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        print(n,0);
    }

    private static void print(int n, int i) {
        if(i>n){
            return;
        }
        System.out.println(i);
        print(n,++i);
    }


}
