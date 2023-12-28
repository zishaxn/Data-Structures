package arrays;

import java.util.HashMap;

public class UniqueOcurrence {
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
