package recursion;

public class BinarySearch_03 {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        System.out.println(recursiveBinarySearch(arr,10,0, arr.length-1));
    }

    private static int recursiveBinarySearch(int[] arr, int target,int start,int end) {
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(arr[mid]>target){
           return recursiveBinarySearch(arr,target,start,mid-1);
        } else if (arr[mid]<target) {
            return recursiveBinarySearch(arr,target,mid+1,end);
        }
        else{
            return mid;
        }
    }
}
