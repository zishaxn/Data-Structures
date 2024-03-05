package arrays;

import java.util.Arrays;

public class P21_MergeSortedArrays {
    public static void main(String[] args) {
        int[]arr1 = {2,4,6,0,0,0};
        int[]arr2 = {1,3,5};
        merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int n1 = m-1;
            int n2 = n-1;
            int k = m+n-1;
            while(n1>=0 && n2>=0){
                if(nums1[n1]>nums2[n2]){
                    nums1[k--]=nums1[n1--];
                }
                else{
                    nums1[k--]=nums2[n2--];
                }
            }
            while(n2>=0){
                nums1[k--]=nums2[n2--];
            }
        }
}
