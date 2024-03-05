package arrays;
public class P18_MissingNumbers {
    public static void main(String[] args) {
        int[]arr = {0,1,3};
        System.out.println(missingNumber(arr));

    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i : nums) {
            sum = i + sum;
        }
        return expectedSum - sum;
    }
}
