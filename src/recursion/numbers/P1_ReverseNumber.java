package recursion.numbers;

public class P1_ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNumber(1234));
    }

    public static int reverseNumber(int num) {
        int numberOfDigits = (int) (Math.log10(num) + 1);
        return helper(num,numberOfDigits);
    }

    private static int helper(int num, int numberOfDigits) {
        if(num/10==0){
            return num;
        }
        int toBeMultiplied = (int)Math.pow(10,numberOfDigits-1);
        return (num%10)*toBeMultiplied + helper(num/10,numberOfDigits-1);
    }


}
