package arrays;

import java.util.Arrays;

public class P9_Sort01 {
    public static void main(String[] args) {
        int[]arr = {0 ,1 ,1 ,0 ,1 ,0 ,1};
        sortZeroesAndOne(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortZeroesAndOne(int[] arr) {
        int start =0;
        int end = arr.length-1;
        while(start<end){
            if(arr[start]==1){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                end--;
            }
            else{
                start++;
            }
        }
    }
}
