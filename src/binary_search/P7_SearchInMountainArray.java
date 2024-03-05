package binary_search;

//https://leetcode.com/problems/find-in-mountain-array/
//1095. Find in Mountain Array

/*Approach:
* We know that mountain array is an array where the array is ascending and reaches peak point
* So approach is that we will first find peak element than we will check if target exist in left of peak
* if it exists in left of peak then return,and if does not exist in left then check in right hand
*  */



public class P7_SearchInMountainArray {
    public static void main(String[] args) {
        int[] mountainArr = {1};
        int target = 0;
        System.out.println(findInMountainArray(target, mountainArr));
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int peakIndex = peakIndex(mountainArr);
        int leftHalf = binarySearchOrderAgnostic(mountainArr, target, 0, peakIndex);
        if (leftHalf != -1) {
            return leftHalf;
        } else {
            return binarySearchOrderAgnostic(mountainArr, target, peakIndex, mountainArr.length - 1);
        }
    }

    private static int peakIndex(int[] mountainArray) {
        int start = 0;
        int end = mountainArray.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mountainArray[mid] > mountainArray[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int binarySearchOrderAgnostic(int[] mountainArray, int target, int start, int end) {
        boolean flag = mountainArray[start] > mountainArray[end];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mountainArray[mid] > target) {
                if (flag) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else if (mountainArray[mid] < target) {
                if (flag) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                return mid;
            }
        }
        return -1;
    }
}
