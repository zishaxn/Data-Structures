package recursion.numbers;

public class P2_CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome(1254321));
    }

    private static boolean checkPalindrome(int num) {
        String number = ""+num;
        return helper(number,0,number.length()-1);

    }

    private static boolean helper(String number, int start, int end) {
        if(start>=end){
            return true;
        }
        if (number.charAt(start) != number.charAt(end)) {
            return false;
        }
        return helper(number,start+1,end-1);
    }

}
