package arrays;

import java.util.Arrays;

public class P22_AssignCookies {
    public static void main(String[] args) {
        int[] greed = {3, 2, 1};
        int[] size = {1, 2, 3};
        System.out.println(findContentChildren2(greed, size));
    }

    private static int findContentChildren2(int[] greed, int[] size) {
        Arrays.sort(greed);
        Arrays.sort(size);
        int count = 0;
        int g = 0;
        int s = 0;
        while (g < greed.length && s < size.length) {
            if (greed[g] <= size[s]) {
                g++;
                count++;
            }
            s++;
        }
        return count;
    }

    //    it works but, O(n2)
    public static int findContentChildren(int[] greed, int[] size) {
        int count = 0;
        Arrays.sort(greed);
        Arrays.sort(size);
        for (int k : greed) {
            for (int j = 0; j < size.length; j++) {
                if (k <= size[j]) {
                    count++;
                    size[j] = -1;
                    break;
                }
            }
        }
        return count;
    }
}
