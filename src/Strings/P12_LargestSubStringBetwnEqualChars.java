package Strings;

import java.util.HashMap;

public class P12_LargestSubStringBetwnEqualChars {
    public static void main(String[] args) {
        String s = "ABCDBC";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
    public static int maxLengthBetweenEqualCharacters(String s) {
        char[]str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int end = str.length-1;
            while(i <end){
                if(str[i]==str[end]){
                    return end- i -1;
                }
                end--;
            }
        }
        return -1;
    }

    public static int maxLengthBetweenEqualCharacters1(String s) {
        // Initialize a HashMap to store the last index of each character encountered
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        int maxLength = -1;

        // Iterate through the string to find the maximum length between equal characters
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // If the character is encountered before, calculate the length between the current index and the last index of the character
            if (lastIndexMap.containsKey(currentChar)) {
                int lastIndex = lastIndexMap.get(currentChar);
                maxLength = Math.max(maxLength, i - lastIndex - 1);
            } else {
                // If the character is encountered for the first time, record its index
                lastIndexMap.put(currentChar, i);
            }
        }

        return maxLength;
    }
}
