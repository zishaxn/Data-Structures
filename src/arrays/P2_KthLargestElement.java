package arrays;


import java.util.Arrays;

//215. Kth Largest Element in an Arra
public class P2_KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println( findKthLargest(nums,k));
//        System.out.println(findKthLargest2(nums,k));

    }

    private static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i : nums) {
            if(k==0){
                return i;
            }
            else{
                k--;
            }
        }
        return 0;
    }


}
