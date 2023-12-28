package recursion.numbers;

// Search if an element is present in array using recursion.
public class P1_PresentInArray {
    public static void main(String[] args) {
        int[]arr = {5,87,7,2,1,3};
        int x = 7;
        System.out.println(present(arr,x));
    }

    private static boolean present(int[] arr, int x) {
        if(arr.length==0){
            return false;
        }
        if(arr[0]==x){
            return true;
        }
        int []reducedArray = new int[arr.length-1];
        System.arraycopy(arr, 1, reducedArray, 0, arr.length - 1);
        return present(reducedArray,x);
    }
}
