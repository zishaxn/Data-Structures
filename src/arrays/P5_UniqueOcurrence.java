package arrays;

import java.util.HashMap;

/*
* 1207. Unique Number of Occurrences
Given an array of integers arr, return true if the number of occurrences of each value in the array is
* unique or false otherwise.
*
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation:The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same
number of occurrences.
*/

//https://leetcode.com/problems/unique-number-of-occurrences/


public class P5_UniqueOcurrence {
    public static void main(String[] args) {
        int[]arr = {1,2,2,1,1,3};
        System.out.println(uniqueOcurr(arr));
    }

    private static boolean uniqueOcurr(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int num : nums) {
            if (map.containsValue(num)) {
                continue;
            }
            int count = 0;
            for (int k : nums) {
                if (num == k)
                    count++;
            }
            if (map.containsKey(count)) {
                return false;
            }
            else map.put(count, num);
        }
        return true;
    }


}
