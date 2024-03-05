package Strings;

public class P5_ReverseStringWhole {
    public static void main(String[] args) {
        String str = "Welcome to Coding Ninjas";
        System.out.println(reverseWordWise(str));
    }

    private static String reverseWordWise1(String str) {
        String[]s = str.split(" ");
//        StringBuilder sb = new StringBuilder();
        String sb = " ";
        for (int i = s.length-1; i >=0 ; i--) {
//            sb.append(s[i]);
            sb+=s[i]+' ';
        }

//        return sb.toString();
        return sb;
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
