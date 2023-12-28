package recursion;

public class PowerOfNumber_02 {
    public static void main(String[] args) {
        System.out.println(powerOfNum(5,125));
    }

    private static int powerOfNum(int num, int power) {
        if(power==0){
            return  1;
        }
        return powerOfNum(num,power-1)*num;
    }
}
