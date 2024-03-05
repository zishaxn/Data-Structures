package arrays;

import  java.util.HashMap;
public class P3_FindUnique_GFG {
    public static void main(String[] args) {
        int[] arr = {10, 11, 11, 5, 10, 5, 5, 10, 10, 5, 10, 10, 11, 10, 10, 10, 5, 10, 5, 11, 10, 5, 11, 11, 10};
        System.out.println(findUnique(arr,25,6));
    }

    public static int findUnique(int nums[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : nums) {
            if (map.containsKey(key)) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int key : nums) {
            if (map.containsKey(key) && map.get(key)%k != 0) {
                return key;
            }
        }

        return -1;
    }
}
