package Strings;

public class P6_PrintSubstrings {
    public static void main(String[] args) {
        String str = "COD";
        subStrings(str);
    }

    private static void subStrings(String s) {
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i; j <s.length() ; j++) {
                System.out.println(s.substring(i,j+1));
            }
        }
    }
}
