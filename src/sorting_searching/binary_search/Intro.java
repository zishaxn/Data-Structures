package sorting_searching.binary_search;

public class Intro {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,5};
        int target = 9;
        System.out.println(binarySearch(arr,target));
        System.out.println(binarySearchOrderAgnostic(arr,target));;
    }


    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int binarySearchOrderAgnostic(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean flag = arr[start] > arr[start + 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                if (flag) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else if (arr[mid] < target) {
                if (flag) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                return mid;
            }
        }
        return Integer.MAX_VALUE;
    }
}
