package recursion.arrays;

public class P1_CheckIfArraysSorted {
    public static void main(String[] args) {
        int[]arr = {1, 2, 3, 2, 4, 5};
        System.out.println(isSorted(arr));
    }

    private static boolean isSorted(int[] arr) {
        return helper(arr,0,arr.length-1);
    }

    private static boolean helper(int[] arr, int si, int ei) {
        if(si>=ei){
            return true;
        }

        if(arr[si]<arr[ei]){
            return helper(arr,si+1,ei-1);
        }
        else{
            return false;
        }
    }
}
