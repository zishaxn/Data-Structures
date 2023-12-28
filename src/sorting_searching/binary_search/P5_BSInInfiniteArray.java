package sorting_searching.binary_search;

// Question is to do BS in an infinite array meaning we cant use the the arr length property.

/*
* Approach : for doing BS we need a range, so what we did was to divide our array into chunks.
* and these chunks were dooubled each time, meaning first we will have a chunk where only 2 elements
* are there and then next we will have a chunk of 4 elements and then 8 and so on.
* the moment we got that our end of chunk is greater than the target , we will perform BS on that chunnk.*/
public class P5_BSInInfiniteArray {
    public static void main(String[] args) {
        int[]arr= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int target = 12;

        System.out.println(searchRange(arr,target));

    }

    private static int searchRange(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while(target>arr[end]){
            int tempStart = end+1;
            end = (tempStart*2)+1;
//            end=end+(end-start+1)*2;
            start=tempStart;
        }
        return binarySearch(arr,start,end,target);
    }

    private static int binarySearch(int[] arr, int start, int end ,int target) {
        while (start <= end) {
            int mid = start + (end-start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
