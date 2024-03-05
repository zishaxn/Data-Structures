package binary_search;

// find the smallest number that is equal to or greater than the given number.
public class P1_CeillingNumber {
    public static void main(String[] args) {
        int[] arr = {11,12,13,15,16};
        int num = 18;
        System.out.println(ceillingOfNumber1(arr, num));
    }

    private static int ceillingOfNumber1(int[] arr, int num) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]>num){
                end=mid-1;
            } else if (arr[mid]<num) {
                start=mid+1;
            }
            else if(arr[mid]==num){
                return mid;
            }
        }
        if(start<arr.length){
            return start;
        }
        else {
            return Integer.MIN_VALUE;
        }

    }

    private static int ceillingOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ceiling = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid]==target){
                return  mid;
            } else if (arr[mid]<target) {
                start=mid+1;
            }
            else{
                end=mid-1;
                ceiling=Math.min(ceiling,mid);
            }
        }
        return ceiling;
    }
}

