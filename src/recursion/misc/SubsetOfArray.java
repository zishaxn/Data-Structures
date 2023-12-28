package recursion.misc;

import java.util.Arrays;

public class SubsetOfArray {
    public static void main(String[] args) {
        int[] arr = {15, 20, 12};
        System.out.println(Arrays.deepToString(subsets(arr)));
    }

    public static int[][] subsets(int[] input) {
        return subsetsHelper(input, 0);
    }

    private static int[][] subsetsHelper(int[] input, int startIndex) {
        if (startIndex == input.length) {
            int[][] output = new int[1][0];
            return output;
        }

        int[][] smallOutput = subsetsHelper(input, startIndex + 1);
        int[][] output = new int[smallOutput.length * 2][];
        int k = 0;
        for (int i = 0; i < smallOutput.length; i++) {
            output[k] = new int[smallOutput[i].length];
            for (int j = 0; j < smallOutput[i].length; j++) {
                output[k][j] = smallOutput[i][j];
            }
            k++;
        }
        for (int i = 0; i < smallOutput.length; i++) {
            output[k] = new int[smallOutput[i].length + 1];
            output[k][0] = input[startIndex];
            for (int j = 1; j <=smallOutput[i].length; j++) {
                output[k][j] = smallOutput[i][j-1];
            }
            k++;

        }
        return output;
    }
}
