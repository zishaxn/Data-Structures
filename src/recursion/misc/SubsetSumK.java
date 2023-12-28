package recursion.misc;

public class SubsetSumK {
    public static void main(String[] args) {
       int[]input={17 ,18 ,6, 11 ,2 ,4 };
       int k = 6;
        int output[][] = subsetsSumK(input, k);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] subsetsSumK(int arr[], int k) {
        // Call the helper function to generate all the subsets that sum up to k
        return subsetsSumKHelper(arr, 0, k);
    }

    private static int[][] subsetsSumKHelper(int[] arr, int startIndex, int k) {
        // If we have reached the end of the array, return an empty or a singleton array depending on whether k is 0
        if (startIndex == arr.length) {
            if (k == 0) {
                return new int[1][0];
            } else {
                return new int[0][0];
            }
        }

        // Generate all the subsets that do not include the current element
        int[][] smallOutput1 = subsetsSumKHelper(arr, startIndex + 1, k);

        // Generate all the subsets that include the current element
        int[][] smallOutput2 = subsetsSumKHelper(arr, startIndex + 1, k - arr[startIndex]);

        // Combine the two small outputs to obtain the final result
        int[][] output = new int[smallOutput1.length + smallOutput2.length][];
        int index = 0;
        for (int i = 0; i < smallOutput1.length; i++) {
            // Copy the subsets that do not include the current element
            output[index] = smallOutput1[i];
            index++;
        }
        for (int i = 0; i < smallOutput2.length; i++) {
            // Create a new subset that includes the current element by adding it to the beginning of the subset
            output[index] = new int[smallOutput2[i].length + 1];
            output[index][0] = arr[startIndex];
            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[index][j + 1] = smallOutput2[i][j];
            }
            index++;
        }

        // Return the final result
        return output;
    }
}
