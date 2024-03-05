package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
public class P23_Sort012 {
    public static void main(String[] args) {
        int[]arr = {1,2,0,0,1,2,0,10,0};
        sort01(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort01(int[] nums) {
        int zero =0;
        int one  =0;
        for(int i :nums) {
            if (i == 0) {
                zero++;
            }
            if (i == 1) {
                one++;
            }
        }

        int i;
        for(i = 0;i<zero;i++){
            nums[i]=0;
        }
        for(i=zero;i<zero+one;i++){
            nums[i]=1;
        }
        for(i=zero+one;i<nums.length;i++){
            nums[i]=2;
        }
    }
}
