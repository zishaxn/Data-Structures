package recursion.numbers;
/*
* return the last index at which the target integer appears in the array.
If the target is not present, the method should return -1.*/

public class P6_LastIndexPresent {
    public static void main(String[] args) {
        int[]arr = {1,2,3,1};
        int target=1;
        System.out.println(lastIndex(arr,target));
//        System.out.println(lastIndex(arr,target,0));
    }

    private static int lastIndex(int[] arr, int target, int startIndex) {
        if(startIndex==arr.length){
            return -1;
        }
        int k = lastIndex(arr,target,startIndex+1);
        if(k!=-1){
            return k;
        }
        else{
            if(arr[startIndex]==target){
                return startIndex;
            }
            else {
                return -1;
            }
        }
    }

    private static int lastIndex(int[] arr, int target) {
        if(arr.length==0){
            return -1;
        }

        int []reducedArray = new int[arr.length-1];
        System.arraycopy(arr, 1, reducedArray, 0, arr.length - 1);
        int k = lastIndex(reducedArray,target);
        if(k!=-1){
            return k+1;
        }
        else {
            if (arr[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

    }
}
