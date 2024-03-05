package recursion.numbers;

public class P3_CountZeroes {
    public static void main(String[] args) {
        System.out.println(countZeroes(1013040));
    }

    private static int countZeroes(int num) {
        if(num==0){
            return 1;
        }
        if(num<10){
            return 0;
        }
        int lastDigit = num%10;
        if(lastDigit==0){
            return 1+ countZeroes(num/10);
        }
        else{
            return countZeroes(num/10);
        }
    }
}
