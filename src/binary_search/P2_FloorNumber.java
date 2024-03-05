package binary_search;
// find the biggest number that is equal to or less than the given number.
public class P2_FloorNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        int num =6 ;
        System.out.println(floorOfNumber1(arr, num));
    }

    private static int floorOfNumber1(int[] arr, int num) {
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
                return arr[mid];
            }
        }
        return end;
    }
    private static int floorOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int floor = Integer.MIN_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid]==target){
                return  mid;
            } else if (arr[mid]>target) {
                end=mid-1;
            }
            else{

                start=mid+1;
                floor=Math.max(floor,arr[mid]);
            }
        }
        return floor;
    }
}
