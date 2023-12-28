package Strings;
//in this question we have to return the character from the given in string that is occurring max.
// eg in this, "aaaabbbbbbbccc" b is occuring max:


/* APPROACH:
    we will create an array and then we will iterate over the string, and suppose strings has 'a' so its ASCII value is
    65 so we will go to arr[s.chart(i) === arr[65] and that will initially have 0 , so we will update it with +1 and so on
    we will do it for every char (basically loop) .
    And then we will again iterate over chars using array and find the char with max value. and return it
* */

public class P10_HighestOccurring {
    public static void main(String[] args) {
        String s = "aaaabbbbbbbccc";
        System.out.println(highest1(s));
    }

    private static char highest(String s) {
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] = arr[s.charAt(i)] + 1;
        }

        int maxCount = -1;
        char maxOccur = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] > maxCount) {
                maxCount = arr[s.charAt(i)];
                maxOccur = s.charAt(i);
            }
        }
        return maxOccur;
    }

    /*Approach 2 :
     * Same but complexity will be O(n) instead of O(2n) */
    private static char highest1(String s) {
        int maxCount = -1;
        char maxOccur = ' ';
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
//            we are updating the value inside array
            arr[s.charAt(i)]++;

            if (arr[currChar] > maxCount) {
                maxCount = arr[currChar];
                maxOccur = currChar;
            }
        }
        return maxOccur;
    }
}
