package sorting_searching.binary_search;

import java.util.Arrays;

public class BinarySearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {8, 9, 10}
        };
        int[] result = search(arr, 11);
        System.out.println(Arrays.toString(result));
    }

    private static int[] search(int[][] arr, int target) {
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[j][k] == target) {
                    return new int[]{j, k};
                }
            }
        }
        return new int[]{-1, -1}; // Return an array indicating target not found
    }
}
