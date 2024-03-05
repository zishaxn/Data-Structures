package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class
P7_PairSum {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5};
        int target = 5;
        List<int[]> result = pairSum (arr, target);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
        System.out.println(pairSum(arr,target));
    }


//    My brute force
    private static int[][] pairSum1(int[] arr, int target) {
        int[][]ans= new int[arr.length][arr.length];
//        ArrayList<int[]>list = new ArrayList<>();
        int r=0;
        int c=0;
        for (int i = 0; i <arr.length ; i++) {
            int start = i;
            int end = arr.length-1;
            while(start<end){
                if(arr[start]+arr[end]==target){
                    ans[r][c]=start;
//                    list.add()
                    c++;
                    ans[r][c]=end;
//                    start++;
                    arr[end]=Integer.MIN_VALUE;
                    arr[start]=Integer.MIN_VALUE;
                    end--;


                    r++;
                    c=0;

                }
                else{
                    end--;
                }
            }
        }
        return ans ;
    }

    public static List<int[]> pairSum2(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int currentSum = arr[start] + arr[end];

            if (currentSum == target) {
                result.add(new int[]{arr[start], arr[end]});
                // Skip duplicates for the second element
                while (start < end && arr[start] == arr[start + 1]) {
                    start++;
                }
                // Skip duplicates for the first element
                while (start < end && arr[end] == arr[end - 1]) {
                    end--;
                }
                start++;
                end--;
            } else if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }

    public static List<int[]> pairSum(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                int[] pair = new int[]{Math.min(num, complement), Math.max(num, complement)};
                result.add(pair);
            }

            map.put(num, 1);
        }
//        Arrays.sort(result);
        return result;
    }

}
