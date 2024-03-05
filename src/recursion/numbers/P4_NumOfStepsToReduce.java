package recursion.numbers;

public class P4_NumOfStepsToReduce {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(20));
    }
    public static int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        if(num%2==0){
            return 1+ numberOfSteps(num/2);
        }
        else{
            return 1 + numberOfSteps(num-1);
        }
    }

}
