package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays_2 {
    public static void main(String[] args) {
        int[]arr1 = {5,2,1,4,4};
        int[]arr2 = {1,4,0,1};
        System.out.println(Arrays.toString(intersection(arr1,arr2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer>ans = new ArrayList<>();
        for (int k : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (k == nums2[j]) {
                    nums2[j] = Integer.MIN_VALUE;
                    ans.add(k);
                    break;
                }
            }
        }
        int[]ansArray = new int[ans.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i]= ans.get(i);
        }
        return ansArray;
    }
}
