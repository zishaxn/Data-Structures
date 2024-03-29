package arrays;

//1295 find even num of digits

//simple find if num of digits in each individual nums are even if yes then incrase count by 1
// to find num of digits num/10 ==> loop
public class P2_FindEvenNumOfDigits {
    public static void main(String[] args) {
        int[] arr = {52, 4823, 321, 1111, 2};
        System.out.println(findNumbers(arr));
    }


    public static int findNumbers(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            if (numDigits(num)) {
                ans++;
            }
        }
        return ans;

    }

    private static boolean numDigits(int nums) {
        nums = Math.abs(nums);

        int count = 0;

        // Loop until the number becomes 0, removing one digit at a time
        while (nums > 0) {
            count++;
            nums = nums / 10; // Remove the last digit
        }

        return count%2==0;
    }

}