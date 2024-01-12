package Strings;
/* What we can do is first convert the string into arrays of strings .
* Then on each string iterating and reversing it and then we can use String.join() method that takes two argumnets
* one delimiter and other the arryay of string.it converts an array of strings into a string*/



public class P4_ReverseEachWord {
    public static void main(String[] args) {
        String str = "Hello I am Aadil";

        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String input) {
        String[]s = input.split(" ");
        for (int i = 0; i <s.length ; i++) {
            s[i]=reverse1(s[i]);
        }

        return String.join(" ", s);
    }

    private static String reverse1(String str) {
        int length = str.length();
        StringBuilder ans = new StringBuilder();
        for (int i = length-1; i >=0 ; i--) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
