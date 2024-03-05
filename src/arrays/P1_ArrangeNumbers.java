package arrays;

import java.util.Arrays;

public class P1_ArrangeNumbers {

    public static void main(String[] args) {
        int []arr = new int[6];
        arrange(arr,6);
        System.out.println(Arrays.toString(arr));
    }

    public static void arrange(int[] arr, int num) {
        int n = 1;
        int start = 0;
        int end = num-1;
        while(start<=end){
            if(n%2==0){
                arr[end]=n;
                end--;
                n++;
            }
            else{
                arr[start]=n;
                start++;
                n++;
            }
        }
    }
}
