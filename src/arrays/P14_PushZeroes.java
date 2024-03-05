package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/

/*Approach:
We have {0,1,0,3,12} we want to maintain order while moving zeroes at end, so we can think in this way
-> we will iterate and while iterating when we encounter any non zero number we will move it to the last position
where we encountered zero,
Eg: we have counter count, and we start iterarting and at first a zero is there so noting and our counter is still at 0,
now at 2nd we got non zero so we will move that non zero to the last time we encountered zero that is at the position of count.

*/
public class P14_PushZeroes {
    public static void main(String[] args) {
        int[]arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes(int[] arr) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[count++]=arr[i];
            }
        }
        while(count<arr.length){
            arr[count++]=0;
        }
    }

    //    does not maintain order;
    public static void moveZeroes1(int[] arr) {
        int start =0;
        int end =arr.length-1;
        while (start<end){
            if(arr[start]==0){
                int temp =arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                end--;
            }
            else {
                start++;
            }
        }
    }
}
