package recursion.arrays;

import java.util.ArrayList;

public class P4_First_LastIndex {
    public static void main(String[] args) {
        int[]arr = {5,8,8};

        System.out.println(linearSearch(arr,8, arr.length-1));
    }

    private static ArrayList<Integer> linearSearch(int[] arr, int target ,int currIndex, ArrayList<Integer>ans ) {
        if (currIndex == -1) {
            return ans; // Return the ArrayList when all indices have been checked
        }

        if (arr[currIndex] == target) {
            ans.add(currIndex); // Add the index to the ArrayList if the element is found
        }

        // Recursively search in the rest of the array
        return linearSearch(arr, target, currIndex - 1, ans);
    }

    private static ArrayList<Integer> linearSearch(int[]arr,int target,int currIndex){
        if(currIndex==-1){
            return new ArrayList<>();
        }

        ArrayList<Integer>ans = linearSearch(arr,target,currIndex-1);

        if(arr[currIndex]==target){
            ans.add(currIndex);
            return ans;
        }

        return ans;
    }
}
