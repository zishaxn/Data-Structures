package arrays;

import java.util.Arrays;

public class FindDuplicateSimple {
    public static void main(String[] args) {
        int[]arr = {2,6,8,2,1,3};
        System.out.println(findDuplicate(arr));
    }

    private static int duplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
