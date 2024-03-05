package recursion.arrays;

import java.util.ArrayList;

public class P3_LinearSearch {
    public static void main(String[] args) {
        int[]arr = {5,8,1,2,43,8,9};

        System.out.println(linearSearch(arr, arr.length-1));
    }

    private static int linearSearch(int[] arr, int currIndex) {
        if(currIndex==-1){
            return -1;
        }

        if(arr[currIndex]== 8){
            return currIndex;

        }

        return linearSearch(arr,currIndex-1);
    }
}
