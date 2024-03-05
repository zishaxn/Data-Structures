package arrays;

import java.util.*;

public class P24_TransposeMatrix {
    public static void main(String[] args) {
        int[][]arr = {{1,2,3},{4,5,6}};


        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("---------------------------------------------------");
        arr = transpose(arr);

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][]transpose(int[][]arr){

        int rows = arr.length;
        int cols = arr[0].length;
        int[][]ans = new int[cols][rows];
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols ; j++) {
                ans[j][i]=arr[i][j];
            }
        }
        return ans;
    }
}
