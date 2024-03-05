package arrays;

import java.util.Arrays;

public class P10_SwapNumbers {

//    https://www.codingninjas.com/studio/problems/swap-alternate_624941
    public static void main(String[] args) {
        int[]arr= {1,2,3,4,5,6,7};
        swapAlternate(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void swapAlternate(int arr[]) {
        for(int i =0;i<arr.length-1;i+=2){
            int temp = arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }
}
