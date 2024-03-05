package Strings;

public class P6_PrintSubstrings {
    public static void main(String[] args) {
        String str = "ABC";
        subStrings(str);
    }

    private static void subStrings(String s) {
        StringBuilder currString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            currString.append(s.charAt(i));
            System.out.println(currString);
            for (int j = i + 1; j < s.length(); j++) {
                currString.append(s.charAt(j));
                System.out.println(currString);
            }

            currString.setLength(0);
        }
    }
}
