package arrays;

import java.util.ArrayList;
import java.util.Arrays;


//https://www.codingninjas.com/studio/problems/triplets-with-given-sum_893028?leftPanelTabValue=PROBLEM


// Approach:
/*

 */

public class P15_TripletSum {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,0};
        int target = 5;

        int n = arr.length;

        ArrayList<ArrayList<Integer>>ans = findTriplets(arr,n,target);
        System.out.println(ans);


    }

    private static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n ,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int currSum = arr[i] + arr[left] + arr[right];
                if (currSum == target) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(arr[i]);
                    ans.add(arr[left]);
                    ans.add(arr[right]);
                    result.add(ans);
                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if (currSum<target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
