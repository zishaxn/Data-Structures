package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//# https://leetcode.com/problems/intersection-of-two-arrays/

//In this question we required to only return numbers that are common in both and they should occur only once,
// It means that if l1 = 1,2,2,3,4,6 and l2 = 1,2,2,5 then it should return [1,2] not [1,2,2]

/* Approach:
we will add first arr in map and then when will iterate over second array and encounter interscetion we,will
remove the element from the map, and in this way it wont  get caught further.
Eg: we added 1,2,2,3,4,6 in map and in the second arr [1,2,2,5] we are at first 2, so we will see that 2 is in map so we will delete it and then map will become
 [1 ,3,4,6] now when we again encounter 2 in [1,2,2,5] we wont find it in map.
 */

public class P11_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[]arr1 = {5,2,1,4,4};
        int[]arr2 = {1,4,0,1};
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
