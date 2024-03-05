package recursion.searchingalgorithms;

import java.util.ArrayList;

public class P1_LinearSearch {
    public static void main(String[] args) {
        int[]arr={12,5,15,65,25,15};
        int target = 15;
//        System.out.println(target+" is Located at "+ linearSearch(arr,target)+" Index");
        System.out.println(allOccurrences(arr,target));
    }

    private static ArrayList<Integer> allOccurrencesHelper1(int[] arr, int target,int index) {
        ArrayList<Integer>ans = new ArrayList<>();
        if(index==arr.length){
            return ans;
        }
        if(arr[index]==target){
            ans.add(index);
        }
         ArrayList<Integer> ansFromBelowCalls = allOccurrencesHelper1(arr,target,index+1);
         ans.addAll(ansFromBelowCalls);
         return ans;
    }

    private static ArrayList<Integer> allOccurrences(int[] arr, int target) {
//        ArrayList<Integer>ans = new ArrayList<>();
//        return allOccurrencesHelper(arr,target,0,ans);
        return allOccurrencesHelper1(arr,target,0);
    }

    private static ArrayList<Integer> allOccurrencesHelper(int[] arr, int target, int index,ArrayList<Integer>ans) {
        if(index==arr.length){
            return ans;
        }
        if(arr[index]==target){
            ans.add(index);
        }
        return allOccurrencesHelper(arr,target,index+1,ans);
    }

    private static int linearSearch(int[] arr, int target) {
        return linearSearchHelper(arr, target, 0);
    }

    private static int linearSearchHelper(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1; // Element not found
        }
        if (arr[index] == target) {
            return index; // Element found at this index
        } else {
            return linearSearchHelper(arr, target, index + 1); // Continue searching
        }
    }



}
