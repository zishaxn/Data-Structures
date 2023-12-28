package recursion.numbers;

//num of digits in an number
public class P2_NumOfDigits {
    public static void main(String[] args) {
        int num = 24321222;
        System.out.println(numOfDigits(num));
    }

    private static int numOfDigits(int num) {
        if(num%10==0){
            return 0;
        }
        return 1 + numOfDigits(num/10);
    }
}
