package Strings;
//in this question we have to return the character from the given in string that is occurring max.
// eg in this, "aaaabbbbbbbccc" b is occuring max:


/* APPROACH:
    we will create an array and then we will iterate over the string, and suppose strings has 'a' so its ASCII value is
    65 so we will go to arr[s.chart(i) === arr[65] and that will initially have 0 , so we will update it with +1 and so on
    we will do it for every char (basically loop) .
    And then we will again iterate over chars using array and find the char with max value. and return it
* */

import java.util.HashMap;
import java.util.Map;

public class P10_HighestOccurring {
    public static void main(String[] args) {
        String s = "aaaabbbbbbbccc";
//        System.out.println(highest2(s));
        System.out.println(highestOccurring(s));
    }

    private static char highest2(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int max= 0;
        char resultChar = '\0';

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                resultChar=entry.getKey();
            }
        }
        return  resultChar;

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

    private static char highestOccurring(String s){
        int[]arr = new int[256];
        int maxCount = -1;
        char maxOcurr = ' ';
        for (int i = 0; i <s.length() ; i++) {
            char currChar = s.charAt(i);

            arr[currChar]++;

            if(arr[currChar]>maxCount){
                maxCount=arr[currChar];
                maxOcurr=currChar;
            }
        }
        return maxOcurr;
    }
}
