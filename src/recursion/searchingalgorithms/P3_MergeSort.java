package recursion.searchingalgorithms;

import java.util.Arrays;

public class P3_MergeSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        int[]arr1 ={3,2,1};

        mergeSortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

// *************   Merge sort By returning new Array   ******************* ///
    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);

    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        int s1 = 0;
        int s2 = 0;
        int i = 0;
        while (s1 < m && s2 < n) {
            if (nums1[s1] < nums2[s2]) {
                ans[i++] = nums1[s1++];
            } else {
                ans[i++] = nums2[s2++];
            }
        }
        while (s1 < m) {
            ans[i++] = nums1[s1++];
        }
        while (s2 < n) {
            ans[i++] = nums2[s2++];
        }
        return ans;
    }

    // *************   Merge sort In Place   ******************* ///
//    private static void mergeSortInPlace(int[] arr,int start, int end) {
//        if (end-start == 1) {
//            return;
//        }
//        int mid = (start+end)/ 2;
//        mergeSortInPlace(arr, start, mid);
//        mergeSortInPlace(arr, mid, end);
//
//        mergeInPlace(arr,start,mid,end);
//
//    }
//
//    public static int[] mergeInPlace(int[] nums1, int start, int mid, int end) {
//        int[] ans = new int[end-start];
//        int s1 = start;
//        int s2 = mid;
//        int i = 0;
//        while (s1 < mid && s2 < end) {
//            if (nums1[s1] < nums2[s2]) {
//                ans[i++] = nums1[s1++];
//            } else {
//                ans[i++] = nums2[s2++];
//            }
//        }
//        while (s1 < m) {
//            ans[i++] = nums1[s1++];
//        }
//        while (s2 < n) {
//            ans[i++] = nums2[s2++];
//        }
//        return ans;
//    }

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s <= 1) {
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int i = s;
        int j = m;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                i++;
            } else {
                int temp = arr[j];
                System.arraycopy(arr, i, arr, i + 1, j - i);
                arr[i] = temp;
                j++;
                m++;
            }
        }
    }

}
