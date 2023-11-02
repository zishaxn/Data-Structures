package Strings;

public class P5_ReverseStringWhole {
    public static void main(String[] args) {
        String str = "Welcome to Coding Ninjas";
        System.out.println(reverseWordWise(str));
    }

    public static String reverseWordWise(String input) {
        String [] words = input.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            output.append(words[i]).append(" ");
        }
        return output.toString();
    }
}
