package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class P17_FindDuplicateSimple {
    public static void main(String[] args) {
        int[]arr = {2,6,8,2,1,3};
        System.out.println(findDuplicate1(arr));
    }

    private static int duplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    private static int findDuplicate1(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                return i;
            }
            else{
                map.put(i,1);
            }
        }
        return -1;
    }


}
