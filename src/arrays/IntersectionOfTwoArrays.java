package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[]arr1 = {1,2,2,1};
        int[]arr2 = {2,2};
        System.out.println(Arrays.toString(intersection(arr1,arr2)));
    }

    public static int[] intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer>ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i :arr1){
            map.put(i,1);
        }
        for(int i : arr2){
            if(map.containsKey(i)){
                ans.add(i);
                map.remove(i);
            }

        }
        int[]ansArray = new int[ans.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i]= ans.get(i);
        }
        return ansArray;
    }
}
